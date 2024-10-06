package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentStatus;

public class DebitCardPayment implements PaymentStrategy{
    private String cardNumber;

    public DebitCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentStatus doPayment(double amount) {
        return PaymentStatus.SUCCESS;
    }
}
