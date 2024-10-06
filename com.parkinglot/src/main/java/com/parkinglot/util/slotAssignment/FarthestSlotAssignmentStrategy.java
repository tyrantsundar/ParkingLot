package com.parkinglot.util.slotAssignment;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;

import java.util.Optional;

public class

FarthestSlotAssignmentStrategy implements SlotAssignmentStrategy{
    @Override
    public Optional<ParkingSlot> checkParkingSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        return Optional.empty();
    }
}
