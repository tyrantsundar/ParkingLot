package com.parkinglot.dtos.response;

import com.parkinglot.entities.ParkingFloorStatus;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloorResponseDto {
    private String parkingLotName;
    private String floorNumber;
    private List<ParkingSlotResponseDto> parkingSlots;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingFloorStatus parkingFloorStatus;
}
