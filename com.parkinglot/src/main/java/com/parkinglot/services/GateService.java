package com.parkinglot.services;

import com.parkinglot.entities.Gate;
import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.GateType;
import com.parkinglot.entities.ParkingLot;

import java.util.List;

public interface GateService {
    public Gate saveGate(String gateNumber, GateType gateType, GateStatus gateStatus, ParkingLot parkingLot);
    public Gate updateGate(String gateNumber, GateType gateType, GateStatus gateStatus, ParkingLot parkingLot);
    public Gate getGateByNumber(String gateNumber);
    public List<Gate> getAllGates();
    public List<Gate> getGateByStatus(GateStatus gateStatus);
    public void deleteGate(String gateNumber);
}
