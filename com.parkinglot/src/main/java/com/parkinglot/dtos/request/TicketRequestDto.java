package com.parkinglot.dtos.request;

import com.parkinglot.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {

    private String gateNumber;
    private String vehicleNumber;
    private String ownerMobile;
    private VehicleType vehicleType;
    private String operatorName;
    private String parkingLotName;
}
