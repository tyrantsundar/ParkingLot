package com.parkinglot.repositories;

import com.parkinglot.entities.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private static  int previousId = 0;

    public Ticket save(Ticket ticket){
        ticket.setId(previousId++);
        ticket.setNumber("TICKET#"+previousId);
        tickets.put(ticket.getId(),ticket);
        return ticket;
    }

    public Optional<Ticket> getTicket(int ticketId){
        if(tickets.containsKey(ticketId)) {
            Ticket ticket = tickets.get(ticketId);
            return Optional.of(ticket);
        }
        return Optional.empty();
    }
}
