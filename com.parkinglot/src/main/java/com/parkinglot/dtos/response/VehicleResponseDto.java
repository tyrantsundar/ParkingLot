package com.parkinglot.dtos.response;

import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponseDto {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private String registerNumber;
    private VehicleType vehicleType;
    private VehicleOwner vehicleOwner;
}
