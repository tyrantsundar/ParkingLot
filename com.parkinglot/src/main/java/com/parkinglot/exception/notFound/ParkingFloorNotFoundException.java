package com.parkinglot.exception.notFound;

public class ParkingFloorNotFoundException extends RuntimeException{
    private final String name = "PARKING_FLOOR";
    private String value;
    private String type;

    public ParkingFloorNotFoundException(String message, String value, String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}

