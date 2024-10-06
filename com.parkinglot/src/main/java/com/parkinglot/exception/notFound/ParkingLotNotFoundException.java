package com.parkinglot.exception.notFound;

public class ParkingLotNotFoundException extends RuntimeException{
    private final String name = "PARKING_SLOT";
    private String value;
    private String type;

    public ParkingLotNotFoundException(String message, String value, String type) {
        super(message);
        this.value = value;
        this.type = type;
    }
}
