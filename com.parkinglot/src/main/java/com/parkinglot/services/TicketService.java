package com.parkinglot.services;

import com.parkinglot.entities.*;

public interface TicketService {
    public Ticket issueTicket(Vehicle vehicle, Operator operator, Gate entryGate, ParkingLot parkingLot);
    public Ticket getTicketById(int ticketId);
}
