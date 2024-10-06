package com.parkinglot.exception.notFound;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BillNotFoundException extends RuntimeException{
    private String value;

    public BillNotFoundException(String value) {
        super(String.format("BILL-NOTFOUND with %s.",value));
        this.value = value;
    }
}
