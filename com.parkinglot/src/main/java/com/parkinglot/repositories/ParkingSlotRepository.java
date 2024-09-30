package com.parkinglot.repositories;

import com.parkinglot.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Integer> {
    public Optional<ParkingSlot> findBySlotNumber(String slotNumber);
    public List<ParkingSlot> findByVehicleType(VehicleType vehicleType);
}
