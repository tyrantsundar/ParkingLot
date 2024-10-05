package com.parkinglot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "parking_floor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloor extends BaseModel{
    private String floorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "parkingFloor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSlot> parkingSlots;

    @ElementCollection(targetClass = VehicleType.class)
    @Enumerated(EnumType.STRING)
    private List<VehicleType> supportedVehicleTypes;

    @Enumerated(EnumType.STRING)
    private ParkingFloorStatus parkingFloorStatus;

    public void addParkingSlot(ParkingSlot slot) {
        slot.setParkingFloor(this);
        parkingSlots.add(slot);
    }

    public void removeParkingSlot(ParkingSlot slot) {
        parkingSlots.remove(slot);
        slot.setParkingFloor(null);
    }
}
