package com.parkinglot.services.impl;

import com.parkinglot.entities.Vehicle;
import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.entities.VehicleType;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.services.VehicleService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(String registerNumber, VehicleType vehicleType, VehicleOwner vehicleOwner) {
        Vehicle vehicle = new Vehicle(registerNumber ,vehicleType,vehicleOwner);
        Date currDate = new Date();
        vehicle.setCreatedAt(currDate);
        vehicle.setUpdatedAt(currDate);
        Vehicle savedvehicle = vehicleRepository.save(vehicle);
        return savedvehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleByRegisterNumber(String registerNumber) {
        return vehicleRepository.findByRegisterNumber(registerNumber);
    }
}
