package com.parkinglot.exception.invalid;

public class InvalidOperatorException extends RuntimeException{
    private String value;

    public InvalidOperatorException(String value) {
        super(String.format("OPERATOR-NOTFOUND with %s.",value));
        this.value = value;
    }
}