package com.parkinglot.entities;

import java.util.Date;

public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private String refNumber;
    private Date date;
    private PaymentStatus paymentStatus;
}
