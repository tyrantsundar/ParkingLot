package com.parkinglot.exception;

public class NoEmptySlotAvailableException extends RuntimeException {
    private String type;

    public NoEmptySlotAvailableException(String type) {
        super(String.format("%s available for the %s","NoEmptySlot",type));
        this.type = type;
    }
}
