package com.parkinglot.exception.notFound;


public class TicketNotFoundException extends RuntimeException{
    private final String name = "TICKET";
    private String value;
    private String type;

    public TicketNotFoundException(String message, String value , String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}
