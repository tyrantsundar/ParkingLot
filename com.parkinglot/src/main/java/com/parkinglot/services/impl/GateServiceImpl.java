package com.parkinglot.services.impl;

import com.parkinglot.entities.Gate;
import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.GateType;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.services.GateService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GateServiceImpl implements GateService {
    private GateRepository gateRepository;

    GateServiceImpl(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    @Override
    public Gate saveGate(String gateNumber, GateType gateType, GateStatus gateStatus) {
        Gate gate = new Gate(gateNumber,gateType,gateStatus);
        Date currentDate = new Date();
        gate.setCreatedAt(currentDate);
        gate.setUpdatedAt(currentDate);
        Gate savedGate = gateRepository.save(gate);
        return savedGate;
    }

    @Override
    public Gate updateGate(String gateNumber, GateType gateType, GateStatus gateStatus) {
       Gate gate = getGateByNumber(gateNumber);
       gate.setGateNumber(gateNumber);
       gate.setGateType(gateType);
       gate.setGateStatus(gateStatus);
       Date currentDate = new Date();
       gate.setUpdatedAt(currentDate);
       Gate updatedGate = gateRepository.save(gate);
       return updatedGate;
    }

    @Override
    public Gate getGateByNumber(String gateNumber) {
        Optional<Gate> optionalGate = gateRepository.findByGateNumber(gateNumber);
        if(optionalGate.isEmpty()){
            throw  new RuntimeException("Gate is invalid");
        }
        return optionalGate.get();
    }

    @Override
    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }

    @Override
    public List<Gate> getGateByStatus(GateStatus gateStatus) {
        return gateRepository.findByGateStatus(gateStatus);
    }

    @Override
    public void deleteGate(String gateNumber) {
        Gate gate = getGateByNumber(gateNumber);
        gateRepository.delete(gate);
    }
}
