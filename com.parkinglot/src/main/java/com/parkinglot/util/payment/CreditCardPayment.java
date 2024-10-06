package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentStatus;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }
    @Override
    public PaymentStatus doPayment(double amount) {
        return PaymentStatus.SUCCESS;
    }
}
