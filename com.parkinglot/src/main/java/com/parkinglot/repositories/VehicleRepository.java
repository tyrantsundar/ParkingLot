package com.parkinglot.repositories;

import com.parkinglot.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    public Vehicle findByRegisterNumber(String registerNumber);
}
