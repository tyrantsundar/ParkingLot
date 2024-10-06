package com.parkinglot.exception.notFound;


public class GateNotFoundException extends RuntimeException{
    private final String name = "GATE";
    private String value;
    private String type;

    public GateNotFoundException(String message, String value, String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}

