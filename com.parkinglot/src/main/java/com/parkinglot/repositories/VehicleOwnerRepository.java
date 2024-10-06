package com.parkinglot.repositories;

import com.parkinglot.entities.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Integer> {
    public VehicleOwner findByMobile(String mobile);
}
