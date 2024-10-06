package com.parkinglot.dtos.request;

import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDto {
    private String registerNumber;
    private VehicleType vehicleType;
    private String vehicleOwnerMobile;
}
