package com.parkinglot.dtos.response;

import com.parkinglot.entities.ParkingLotStatus;
import com.parkinglot.entities.SlotAssignmentStrategyType;
import com.parkinglot.entities.VehicleType;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotResponseDto {
    private String name;
    private List<ParkingFloorResponseDto> parkingFloors;
    private List<GateResponseDto> entryGates;
    private List<GateResponseDto> exitGates;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
}
