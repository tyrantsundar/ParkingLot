package com.parkinglot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle")
public class Vehicle extends BaseModel{
    private String registerNumber;
    private VehicleType vehicleType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_owner_id")
    private VehicleOwner vehicleOwner;
}
