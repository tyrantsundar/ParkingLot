package com.parkinglot.services.impl;

import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.repositories.VehicleOwnerRepository;
import com.parkinglot.services.VehicleOwnerService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VehicleOwnerServiceImpl implements VehicleOwnerService {
    private VehicleOwnerRepository vehicleOwnerRepository;

    public VehicleOwnerServiceImpl(VehicleOwnerRepository vehicleOwnerRepository) {
        this.vehicleOwnerRepository = vehicleOwnerRepository;
    }

    @Override
    public VehicleOwner saveVehicleOwner(String ownerName, String mobile, String mail) {
        VehicleOwner vehicleOwner = new VehicleOwner(ownerName,mobile,mail);
        Date currDate = new Date();
        vehicleOwner.setCreatedAt(currDate);
        vehicleOwner.setUpdatedAt(currDate);
        VehicleOwner savedVehicleOwner = vehicleOwnerRepository.save(vehicleOwner);
        return savedVehicleOwner;
    }

    @Override
    public VehicleOwner getVehicleOwnerByMobile(String mobile) {
        return vehicleOwnerRepository.findByMobile(mobile);
    }
}
