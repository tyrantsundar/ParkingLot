package com.parkinglot.services.impl;

import com.parkinglot.entities.*;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.services.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingLot saveParkingLot(String parkingLotName, List<ParkingFloor> parkingFloors, List<Gate> entryGates, List<Gate> exitGates, List<VehicleType> supportedVehicleTypes, ParkingLotStatus parkingLotStatus, SlotAssignmentStrategyType slotAssignmentStrategyType) {
        ParkingLot parkingLot = new ParkingLot(parkingLotName,parkingFloors,entryGates,exitGates,supportedVehicleTypes,parkingLotStatus,slotAssignmentStrategyType);
        Date currentDate = new Date();
        parkingLot.setCreatedAt(currentDate);
        parkingLot.setUpdatedAt(currentDate);
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);
        return savedParkingLot;
    }

    @Override
    public ParkingLot getParkingLotByName(String parkingLotName) {
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findByName(parkingLotName);
        if(parkingLotOptional.isEmpty()){
            throw new RuntimeException("ParkingLotName is invalid");
        }
        return parkingLotOptional.get();
    }
}
