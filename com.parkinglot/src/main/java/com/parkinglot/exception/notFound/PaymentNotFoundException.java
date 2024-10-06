package com.parkinglot.exception.notFound;

public class PaymentNotFoundException extends RuntimeException{
    private String value;

    public PaymentNotFoundException(String value) {
        super(String.format("PAYMENT-NOTFOUND with %s.",value));
        this.value = value;
    }
}
