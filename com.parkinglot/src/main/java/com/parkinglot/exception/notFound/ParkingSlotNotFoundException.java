package com.parkinglot.exception.notFound;


public class ParkingSlotNotFoundException extends RuntimeException{
    private final String name = "PARKING_SlOT";
    private String value;
    private String type;

    public ParkingSlotNotFoundException(String message, String value, String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}

