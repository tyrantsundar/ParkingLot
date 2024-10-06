package com.parkinglot.util.slotAssignment;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;

import java.util.Optional;

public interface SlotAssignmentStrategy {
    public Optional<ParkingSlot> checkParkingSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
