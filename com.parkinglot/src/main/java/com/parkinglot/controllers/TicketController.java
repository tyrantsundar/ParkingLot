package com.parkinglot.controllers;

import com.parkinglot.dtos.ResponseStatus;
import com.parkinglot.dtos.request.IssueTicketRequestDTO;
import com.parkinglot.dtos.response.IssueTicketResponseDTO;
import com.parkinglot.entities.Ticket;
import com.parkinglot.services.impl.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request){
        IssueTicketResponseDTO response = new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueTicket(
                    request.getVehicleNumber(),
                    request.getOwnerName(),
                    request.getVehicleType(),
                    request.getGateId(),
                    request.getParkingLotId()
            );
            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setMessage("Ticket Generated Successfully !!!");
        }catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
