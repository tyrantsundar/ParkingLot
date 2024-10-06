package com.parkinglot.exception.notFound;

import com.parkinglot.entities.Operator;

public class OperatorNotFoundException extends RuntimeException{
    private String value;

    public OperatorNotFoundException(String value) {
        super(String.format("OPERATOR-NOTFOUND with %s.",value));
        this.value = value;
    }
}
