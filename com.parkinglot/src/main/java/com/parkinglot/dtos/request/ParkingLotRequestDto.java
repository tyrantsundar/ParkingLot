package com.parkinglot.dtos.request;

import com.parkinglot.entities.ParkingLotStatus;
import com.parkinglot.entities.SlotAssignmentStrategyType;
import com.parkinglot.entities.VehicleType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotRequestDto {
    private String name;
    private List<ParkingFloorRequestDto> parkingFloors;  // Use DTO for ParkingFloor
    private List<GateRequestDto> entryGates;             // Use DTO for Gate
    private List<GateRequestDto> exitGates;              // Use DTO for Gate
    private List<VehicleType> supportedVehicleTypes;
    private ParkingLotStatus parkingLotStatus;
    private SlotAssignmentStrategyType slotAssignmentStrategyType;
}
