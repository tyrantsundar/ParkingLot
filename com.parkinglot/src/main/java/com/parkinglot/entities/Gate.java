package com.parkinglot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gate extends BaseModel{
    private String gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}
