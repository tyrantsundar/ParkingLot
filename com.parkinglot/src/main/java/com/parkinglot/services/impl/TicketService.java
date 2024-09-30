package com.parkinglot.services.impl;

import com.parkinglot.entities.*;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.strategies.SlotAssignmentStrategy;
import com.parkinglot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    GateRepository gateRepository;
    ParkingLotRepository parkingLotRepository;
    TicketRepository ticketRepository;
    VehicleRepository vehicleRepository;

    public TicketService(
            GateRepository gateRepository,
            VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository,
            TicketRepository ticketRepository
    ) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(
            String vehicleNumber,
            String ownerName,
            VehicleType vehicleType,
            int gateId,
            int parkingLotId
    ){

        Optional<Gate> gateOptional = gateRepository.findById(gateId);
        if(gateOptional.isEmpty()){
            throw  new RuntimeException("Invalid Gate Found");
        }
        Gate gate = gateOptional.get();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;
        if(vehicleOptional.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            vehicle.setLicenseNumber(vehicleNumber);
            vehicle = vehicleRepository.save(vehicle);
        }else{
            vehicle = vehicleOptional.get();
        }

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findById(parkingLotId);
        if(parkingLotOptional.isEmpty()){
            throw  new RuntimeException("Invalid Parkinglot Found");
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        SlotAssignmentStrategy strategy = SlotAssignmentStrategyFactory.getStrategy(SlotAssignmentStrategyType.RANDOM);
        Optional<ParkingSlot> parkingSlotOptional = strategy.assignSlot(parkingLot, vehicleType);
        if(parkingSlotOptional.isEmpty()){
            throw new RuntimeException("No Parkingslot Found");
        }

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
//        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());
        ticket.setParkingSlot(parkingSlotOptional.get());

        return ticketRepository.save(ticket);
    }
}
