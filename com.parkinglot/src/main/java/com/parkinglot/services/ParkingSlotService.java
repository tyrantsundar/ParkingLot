package com.parkinglot.services;

import com.parkinglot.entities.*;

import java.util.List;

public interface ParkingSlotService {
    public ParkingSlot saveParkingSlot(String slotNumber, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus);
    public ParkingSlot updateParkingSlot(String slotNumber, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus);
    public ParkingSlot getParkingSlotByNumber(String slotNumber);
    public List<ParkingSlot> getAllParkingSlots();
    public List<ParkingSlot> getParkingSlotByVehicleType(VehicleType vehicleType);
    public void deleteParkingSlot(String slotNumber);
}
