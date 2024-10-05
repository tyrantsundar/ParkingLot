package com.parkinglot.controllers;

import com.parkinglot.dtos.request.ParkingFloorRequestDto;
import com.parkinglot.dtos.request.ParkingLotRequestDto;
import com.parkinglot.dtos.request.ParkingLotRequestDto;
import com.parkinglot.dtos.request.ParkingSlotRequestDto;
import com.parkinglot.dtos.response.ParkingLotResponseDto;
import com.parkinglot.entities.*;
import com.parkinglot.services.ParkingLotService;
import com.parkinglot.services.ParkingFloorService;
import com.parkinglot.services.ParkingSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    private ParkingFloorService parkingFloorService;
    private ParkingSlotService parkingSlotService;
    private ModelMapper modelMapper;

    public ParkingLotController(ParkingLotService parkingLotService, ParkingFloorService parkingFloorService,
                                ParkingSlotService parkingSlotService, ModelMapper modelMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingFloorService = parkingFloorService;
        this.parkingSlotService = parkingSlotService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<ParkingLotResponseDto> saveParkingLot(@RequestBody ParkingLotRequestDto request){

        String parkingLotName = request.getName();
        List<VehicleType> supportedVehicleTypes = request.getSupportedVehicleTypes();
        ParkingLotStatus parkingLotStatus = request.getParkingLotStatus();
        SlotAssignmentStrategyType slotAssignmentStrategyType = request.getSlotAssignmentStrategyType();

        ParkingLot parkingLot = parkingLotService.saveParkingLot(parkingLotName, null, null, null, supportedVehicleTypes,
               parkingLotStatus,slotAssignmentStrategyType);
        ParkingLotResponseDto responseDto = modelMapper.map(parkingLot, ParkingLotResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{parkingLotName}")
    public ResponseEntity<ParkingLotResponseDto> getAllParkingLotByName(@PathVariable("parkingLotName") String parkingLotName){
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(parkingLotName);
        ParkingLotResponseDto responseDto = modelMapper.map(parkingLot, ParkingLotResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
