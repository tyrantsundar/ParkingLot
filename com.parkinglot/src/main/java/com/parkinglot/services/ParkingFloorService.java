package com.parkinglot.services;

import com.parkinglot.entities.*;

import java.util.List;

public interface ParkingFloorService {
    public ParkingFloor saveParkingFloor(ParkingLot parkingLot, String floorNumber, List<ParkingSlot> parkingSlots,
                                         List<VehicleType> supportedVehicleTypes, ParkingFloorStatus parkingFloorStatus);
    public ParkingFloor getParkingFloorByNumber(String floorNumber);
    public List<ParkingFloor> getAllParkingFloors(int parkingLoId);
    public ParkingFloor updateParkingFloor(ParkingLot parkingLot, String floorNumber, List<ParkingSlot> parkingSlots,
                                            List<VehicleType> supportedVehicleTypes, ParkingFloorStatus parkingFloorStatus);
    public void deleteParkingFloor(String floorNumber);
}
