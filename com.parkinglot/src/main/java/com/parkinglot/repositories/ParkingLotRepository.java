package com.parkinglot.repositories;

import com.parkinglot.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Integer> {
    public Optional<ParkingLot> findByName(String name);
}
