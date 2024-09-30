package com.parkinglot.dtos.response;

import com.parkinglot.entities.ParkingSlotStatus;
import com.parkinglot.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotResponseDto {
    private String slotNumber;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;
}
