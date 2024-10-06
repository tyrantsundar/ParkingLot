package com.parkinglot.util.payment;

import com.parkinglot.entities.PaymentStatus;

public class UPIPayment implements PaymentStrategy{
    private String upi;

    UPIPayment(String upi){
        this.upi = upi;
    }
    @Override
    public PaymentStatus doPayment(double amount) {
        return PaymentStatus.SUCCESS;
    }
}
