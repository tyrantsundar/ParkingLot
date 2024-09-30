package com.parkinglot.dtos.request;

import com.parkinglot.entities.ParkingFloorStatus;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloorRequestDto {
    private ParkingLotRequestDto parkingLot;
    private String floorNumber;
    private List<ParkingSlotRequestDto> parkingSlots;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingFloorStatus parkingFloorStatus;
}
