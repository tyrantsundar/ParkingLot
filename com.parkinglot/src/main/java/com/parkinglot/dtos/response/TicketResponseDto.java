package com.parkinglot.dtos.response;

import com.parkinglot.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private Date entryTime;
    private Vehicle vehicle;
    private Operator operator;
    private Gate entryGate;
    private ParkingSlot parkingSlot;
    private ParkingLot parkingLot;
}
