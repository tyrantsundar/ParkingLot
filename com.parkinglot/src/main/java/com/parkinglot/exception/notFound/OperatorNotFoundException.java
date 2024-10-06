package com.parkinglot.exception.notFound;

import com.parkinglot.entities.Operator;

public class OperatorNotFoundException extends RuntimeException{
    private String value;
    private String type;

    public OperatorNotFoundException(String value, String type) {
        super(String.format("%s with %s not found.",type,value));
        this.value = value;
        this.type = type;
    }
}
