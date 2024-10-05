package com.parkinglot.dtos.request;

import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.GateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GateRequestDto {
    private String gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private String parkingLotName;
}
