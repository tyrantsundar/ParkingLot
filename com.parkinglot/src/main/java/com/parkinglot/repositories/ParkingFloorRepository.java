package com.parkinglot.repositories;

import com.parkinglot.entities.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingFloorRepository extends JpaRepository<ParkingFloor,Integer> {
    public Optional<ParkingFloor> findByFloorNumber(String floorNumber);
    public List<ParkingFloor> findAllByParkingLotId(int parkingLotId);
}
