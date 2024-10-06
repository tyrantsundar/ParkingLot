package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentStatus;

public interface PaymentStrategy {
    public PaymentStatus doPayment(double amount);
}
