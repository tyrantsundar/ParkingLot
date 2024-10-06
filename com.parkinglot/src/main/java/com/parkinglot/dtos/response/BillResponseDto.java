package com.parkinglot.dtos.response;

import com.parkinglot.entities.Gate;
import com.parkinglot.entities.Operator;
import com.parkinglot.entities.Payment;
import com.parkinglot.entities.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponseDto {
    private Date exitTime;
    private double totalAmount;
    private Gate gate;
    private Operator operator;
    private List<Payment> paymentList;
    private Ticket ticket;
}
