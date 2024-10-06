package com.parkinglot.services.impl;

import com.parkinglot.entities.*;
import com.parkinglot.exception.NoEmptySlotAvailableException;
import com.parkinglot.exception.notFound.TicketNotFoundException;
import com.parkinglot.repositories.ParkingSlotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.services.TicketService;
import com.parkinglot.util.slotAssignment.SlotAssignmentStrategy;
import com.parkinglot.util.slotAssignment.SlotAssignmentStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private ParkingSlotRepository parkingSlotRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, ParkingSlotRepository parkingSlotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public Ticket issueTicket(Vehicle vehicle, Operator operator, Gate entryGate, ParkingLot parkingLot){

        SlotAssignmentStrategy strategy = SlotAssignmentStrategyFactory.getSlotAssignmentStrategy(parkingLot.getSlotAssignmentStrategyType());
        Optional<ParkingSlot> parkingSlotOptional = strategy.checkParkingSlot(parkingLot, vehicle.getVehicleType());
        if(parkingSlotOptional.isEmpty()){
            throw new NoEmptySlotAvailableException(vehicle.getVehicleType().toString());
        }
        ParkingSlot parkingSlot = parkingSlotOptional.get();
        Date currDate = new Date();

        Ticket ticket = new Ticket();
        ticket.setEntryTime(currDate);
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(entryGate);
        ticket.setParkingSlot(parkingSlot);
        ticket.setOperator(operator);
        ticket.setParkingLot(parkingLot);

        Ticket savedTicket = ticketRepository.save(ticket);
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        parkingSlotRepository.save(parkingSlot);
        return savedTicket;
    }

    @Override
    public Ticket getTicketById(int ticketId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("TicketNotFound",String.valueOf(ticketId), "TicketId");
        }
        return ticketOptional.get();
    }
}
