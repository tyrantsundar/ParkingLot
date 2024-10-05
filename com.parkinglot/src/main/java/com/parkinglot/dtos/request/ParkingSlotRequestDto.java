package com.parkinglot.dtos.request;

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
public class ParkingSlotRequestDto {
    private String slotNumber;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private String parkingFloorNumber;
}
