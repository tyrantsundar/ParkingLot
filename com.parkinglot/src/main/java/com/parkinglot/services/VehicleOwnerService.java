package com.parkinglot.services;

import com.parkinglot.entities.VehicleOwner;

public interface VehicleOwnerService {
    public VehicleOwner saveVehicleOwner(String ownerName, String mobile, String mail);
    public VehicleOwner getVehicleOwnerByMobile(String mobile);
}
