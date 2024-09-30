package com.parkinglot.services.impl;

import com.parkinglot.entities.*;
import com.parkinglot.repositories.ParkingFloorRepository;
import com.parkinglot.services.ParkingFloorService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingFloorServiceImpl implements ParkingFloorService {
    private ParkingFloorRepository parkingFloorRepository;
    ParkingFloorServiceImpl(ParkingFloorRepository parkingFloorRepository){
        this.parkingFloorRepository = parkingFloorRepository;
    }
    @Override
    public ParkingFloor saveParkingFloor(ParkingLot parkingLot, String floorNumber, List<ParkingSlot> parkingSlots,
                                         List<VehicleType> supportedVehicleTypes, ParkingFloorStatus parkingFloorStatus) {
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber(floorNumber);
        parkingFloor.setSupportedVehicleTypes(supportedVehicleTypes);
        parkingFloor.setParkingFloorStatus(parkingFloorStatus);

        parkingFloor.setParkingLot(parkingLot);

        for (ParkingSlot slot : parkingSlots) {
            parkingFloor.addParkingSlot(slot);
        }
        return parkingFloorRepository.save(parkingFloor);
    }

    @Override
    public ParkingFloor getParkingFloorByNumber(String floorNumber) {
        Optional<ParkingFloor> parkingFloorOptional = parkingFloorRepository.findByFloorNumber(floorNumber);
        if(parkingFloorOptional.isEmpty()){
            throw new RuntimeException("ParkingFloor number is invalid");
        }
        return parkingFloorOptional.get();
    }

    @Override
    public List<ParkingFloor> getAllParkingFloors(int parkingLotId) {
        return parkingFloorRepository.findAllByParkingLotId(parkingLotId);
    }

    @Override
    public ParkingFloor updateParkingFloor(ParkingLot parkingLot, String floorNumber, List<ParkingSlot> parkingSlots,
                                           List<VehicleType> supportedVehicleTypes, ParkingFloorStatus parkingFloorStatus) {
        ParkingFloor parkingFloor = getParkingFloorByNumber(floorNumber);
        parkingFloor.setParkingLot(parkingLot);
        parkingFloor.setParkingSlots(parkingSlots);
        parkingFloor.setSupportedVehicleTypes(supportedVehicleTypes);
        parkingFloor.setParkingFloorStatus(parkingFloorStatus);
        Date currentDate = new Date();
        parkingFloor.setUpdatedAt(currentDate);
        return parkingFloorRepository.save(parkingFloor);
    }

    @Override
    public void deleteParkingFloor(String floorNumber) {
        ParkingFloor parkingFloor = getParkingFloorByNumber(floorNumber);
        parkingFloorRepository.deleteById(parkingFloor.getId());
    }
}
