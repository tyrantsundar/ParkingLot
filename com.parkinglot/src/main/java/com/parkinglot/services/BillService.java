package com.parkinglot.services;

import com.parkinglot.entities.*;

import java.util.List;

public interface BillService {
    public Bill doBilling(Gate gate, Operator operator, Ticket ticket, PaymentMode paymentMode, String paymentCardDetail);
    public Bill getBill(int billId);
}
