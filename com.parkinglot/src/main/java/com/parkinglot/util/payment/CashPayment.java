package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentStatus;

public class CashPayment implements PaymentStrategy{
    @Override
    public PaymentStatus doPayment(double amount) {
        return PaymentStatus.SUCCESS;
    }
}
