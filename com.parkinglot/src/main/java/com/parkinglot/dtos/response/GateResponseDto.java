package com.parkinglot.dtos.response;

import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.GateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GateResponseDto {
    private String gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
//    private ParkingLotResponseDto parkingLot;
}
