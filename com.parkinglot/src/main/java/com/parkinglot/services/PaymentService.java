package com.parkinglot.services;

import com.parkinglot.entities.Payment;
import com.parkinglot.entities.PaymentMode;
import com.parkinglot.entities.PaymentStatus;
import java.util.Date;

public interface PaymentService {
    public Payment savePayment(double amount, PaymentMode paymentMode, Date date, String refNumber, PaymentStatus status);
    public Payment getPaymentByRefNumber(String refNumber);
}
