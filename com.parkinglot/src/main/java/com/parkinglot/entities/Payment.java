package com.parkinglot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseModel{
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private String refNumber;
    private Date date;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
