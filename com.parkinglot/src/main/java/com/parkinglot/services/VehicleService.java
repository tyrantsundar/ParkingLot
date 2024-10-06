package com.parkinglot.services;

import com.parkinglot.entities.Vehicle;
import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.entities.VehicleType;

import java.util.List;

public interface VehicleService {
    public Vehicle saveVehicle(String registerNumber, VehicleType vehicleType,  VehicleOwner vehicleOwner);
    public List<Vehicle> getAllVehicle();
    public Vehicle getVehicleByRegisterNumber(String registerNumber);
}
