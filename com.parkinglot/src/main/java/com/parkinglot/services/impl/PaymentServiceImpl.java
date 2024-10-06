package com.parkinglot.services.impl;

import com.parkinglot.entities.Payment;
import com.parkinglot.entities.PaymentMode;
import com.parkinglot.entities.PaymentStatus;
import com.parkinglot.exception.notFound.PaymentNotFoundException;
import com.parkinglot.repositories.PaymentRepository;
import com.parkinglot.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(double amount, PaymentMode paymentMode, Date date, String refNumber, PaymentStatus status) {
        Payment payment = new Payment(amount,paymentMode,refNumber,date,status);
        Date currDate = new Date();
        payment.setCreatedAt(currDate);
        payment.setUpdatedAt(currDate);
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    }

    @Override
    public Payment getPaymentByRefNumber(String refNumber) {
        Optional<Payment> paymentOptional = paymentRepository.findByRefNumber(refNumber);
        if(paymentOptional.isEmpty()){
            throw new PaymentNotFoundException(refNumber);
        }
        return paymentOptional.get();
    }
}
