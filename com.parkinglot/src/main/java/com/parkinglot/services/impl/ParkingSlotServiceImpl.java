package com.parkinglot.services.impl;


import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.ParkingSlotStatus;
import com.parkinglot.entities.VehicleType;
import com.parkinglot.repositories.ParkingSlotRepository;
import com.parkinglot.services.ParkingSlotService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private ParkingSlotRepository parkingSlotRepository;

    @Override
    public ParkingSlot saveParkingSlot(String slotNumber, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus) {
        ParkingSlot parkingSlot = new ParkingSlot(slotNumber,vehicleType,parkingSlotStatus);
        Date currentDate = new Date();
        parkingSlot.setCreatedAt(currentDate);
        parkingSlot.setUpdatedAt(currentDate);
        ParkingSlot saveDParkingSlot = parkingSlotRepository.save(parkingSlot);
        return saveDParkingSlot;
    }

    @Override
    public ParkingSlot updateParkingSlot(String slotNumber, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus) {
        ParkingSlot parkingSlot = getParkingSlotByNumber(slotNumber);
        parkingSlot.setSlotNumber(slotNumber);
        parkingSlot.setVehicleType(vehicleType);
        parkingSlot.setParkingSlotStatus(parkingSlotStatus);
        Date currentdate = new Date();
        parkingSlot.setUpdatedAt(currentdate);
        ParkingSlot updatedParkingSlot = parkingSlotRepository.save(parkingSlot);
        return updatedParkingSlot;
    }

    @Override
    public ParkingSlot getParkingSlotByNumber(String slotNumber) {
        Optional<ParkingSlot> parkingSlotOptional = parkingSlotRepository.findBySlotNumber(slotNumber);
        if(parkingSlotOptional.isEmpty()){
            throw new RuntimeException("ParkingSlot is invalid");
        }
        return parkingSlotOptional.get();
    }

    @Override
    public List<ParkingSlot> getAllParkingSlots() {
        return parkingSlotRepository.findAll();
    }

    @Override
    public List<ParkingSlot> getParkingSlotByVehicleType(VehicleType vehicleType) {
        return parkingSlotRepository.findByVehicleType(vehicleType);
    }

    @Override
    public void deleteParkingSlot(String slotNumber) {
        ParkingSlot parkingSlot = getParkingSlotByNumber(slotNumber);
        parkingSlotRepository.deleteById(parkingSlot.getId());
    }
}
