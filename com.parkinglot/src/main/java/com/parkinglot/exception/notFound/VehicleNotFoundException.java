package com.parkinglot.exception.notFound;


public class VehicleNotFoundException extends RuntimeException{
    private final String name = "VEHICLE";
    private String value;
    private String type;

    public VehicleNotFoundException(String message, String value, String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}

