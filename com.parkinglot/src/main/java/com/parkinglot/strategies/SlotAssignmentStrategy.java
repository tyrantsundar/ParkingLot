package com.parkinglot.strategies;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;

import java.util.Optional;

public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
