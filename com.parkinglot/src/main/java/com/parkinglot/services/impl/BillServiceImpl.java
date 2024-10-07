package com.parkinglot.services.impl;

import com.parkinglot.entities.*;
import com.parkinglot.exception.notFound.BillNotFoundException;
import com.parkinglot.repositories.BillRepository;
import com.parkinglot.repositories.ParkingSlotRepository;
import com.parkinglot.services.BillService;
import com.parkinglot.services.PaymentService;
import com.parkinglot.util.billingUtil.VehicleParkingAmount;
import com.parkinglot.util.payment.PaymentStrategy;
import com.parkinglot.util.payment.PaymentStrategyFactory;
import com.parkinglot.util.randomGenerator.RefNumberGenerator;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private PaymentService paymentService;

    public BillServiceImpl(BillRepository billRepository, ParkingSlotRepository parkingSlotRepository, PaymentService paymentService) {
        this.billRepository = billRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.paymentService = paymentService;
    }

    @Override
    public Bill doBilling(Gate gate, Operator operator, Ticket ticket, PaymentMode paymentMode, String paymentCardDetail) {
        Date currTime = new Date();
        Vehicle vehicle = ticket.getVehicle();

        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(paymentMode,paymentCardDetail);
        double paymentAmount = VehicleParkingAmount.getParkingAmount(vehicle.getVehicleType());
        PaymentStatus paymentStatus = paymentStrategy.doPayment(paymentAmount);
        String paymentRefNumber = RefNumberGenerator.generateRefNumber(6);
        Payment payment = paymentService.savePayment(paymentAmount, paymentMode, currTime, paymentRefNumber, paymentStatus);


        Bill bill = new Bill(currTime,paymentAmount,gate,operator, Collections.singletonList(payment),ticket);
        bill.setCreatedAt(currTime);
        bill.setUpdatedAt(currTime);

        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);

        Bill savedBill = billRepository.save(bill);
        parkingSlotRepository.save(parkingSlot);
        return savedBill;
    }

    @Override
    public Bill getBill(int billId) {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if(billOptional.isEmpty()){
            throw new BillNotFoundException(String.valueOf(billId));
        }
        return billOptional.get();
    }

}
