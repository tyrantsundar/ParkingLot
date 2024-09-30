package com.parkinglot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "parking_lot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingFloor> parkingFloors;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gate> entryGates;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gate> exitGates;

    @ElementCollection(targetClass = VehicleType.class)
    @Enumerated(EnumType.STRING)
    private List<VehicleType> supportedVehicleTypes;

    @ElementCollection(targetClass = ParkingLotStatus.class)
    @Enumerated(EnumType.STRING)
    private ParkingLotStatus parkingLotStatus;

    @ElementCollection(targetClass = SlotAssignmentStrategyType.class)
    @Enumerated(EnumType.STRING)
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
}
