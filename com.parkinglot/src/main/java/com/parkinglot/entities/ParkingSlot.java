package com.parkinglot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parking_slot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlot extends BaseModel{
    private String slotNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private ParkingSlotStatus parkingSlotStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor parkingFloor;

}
