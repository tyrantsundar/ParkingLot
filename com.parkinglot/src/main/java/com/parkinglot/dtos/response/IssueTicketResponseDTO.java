package com.parkinglot.dtos.response;

import com.parkinglot.entities.Ticket;
import com.parkinglot.dtos.ResponseStatus;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String message;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
