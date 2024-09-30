package com.parkinglot.services;

import com.parkinglot.entities.*;
import jakarta.persistence.*;

import java.util.List;

public interface ParkingLotService {

    public ParkingLot saveParkingLot(String parkingLotName, List<ParkingFloor> parkingFloors, List<Gate> entryGates, List<Gate> exitGates,
                                     List<VehicleType> supportedVehicleTypes, ParkingLotStatus parkingLotStatus, SlotAssignmentStrategyType slotAssignmentStrategyType);

    public ParkingLot getParkingLotByName(String parkingLotName);

}
