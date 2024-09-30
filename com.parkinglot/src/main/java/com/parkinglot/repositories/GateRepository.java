package com.parkinglot.repositories;

import com.parkinglot.entities.Gate;
import com.parkinglot.entities.GateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GateRepository extends JpaRepository<Gate,Integer> {
    public List<Gate> findByGateStatus(GateStatus gateStatus);
    public Optional<Gate> findByGateNumber(String gateNumber);
}
