package com.parkinglot.controllers;

import com.parkinglot.dtos.request.ParkingFloorRequestDto;
import com.parkinglot.dtos.request.ParkingLotRequestDto;
import com.parkinglot.dtos.request.ParkingSlotRequestDto;
import com.parkinglot.dtos.response.ParkingFloorResponseDto;
import com.parkinglot.entities.*;
import com.parkinglot.entities.ParkingFloor;
import com.parkinglot.services.ParkingFloorService;
import com.parkinglot.services.ParkingLotService;
import com.parkinglot.services.ParkingSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parkingFloor")
public class ParkingFloorController {
    private ParkingLotService parkingLotService;
    private ParkingFloorService parkingFloorService;
    private ParkingSlotService parkingSlotService;
    private ModelMapper modelMapper;

    ParkingFloorController(ParkingFloorService parkingFloorService, ParkingLotService parkingLotService,
                           ParkingSlotService parkingSlotService, ModelMapper modelMapper){
        this.parkingFloorService = parkingFloorService;
        this.parkingLotService = parkingLotService;
        this.parkingSlotService = parkingSlotService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<ParkingFloorResponseDto> saveParkingFloor(@RequestBody ParkingFloorRequestDto request){
        String parkingLotName = request.getParkingLotName();
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(parkingLotName);

        List<ParkingSlotRequestDto> parkingSlotRequestDtos = request.getParkingSlots();
        List<ParkingSlot> parkingSlots =  parkingSlotRequestDtos == null ? new ArrayList<>() : parkingSlotRequestDtos.stream()
                                            .map(psDto -> parkingSlotService.getParkingSlotByNumber(psDto.getSlotNumber()))
                                            .collect(Collectors.toList());

        ParkingFloor ParkingFloor = parkingFloorService.saveParkingFloor(parkingLot, request.getFloorNumber(), parkingSlots,
                request.getSupportedVehicleTypes(), request.getParkingFloorStatus());

        ParkingFloorResponseDto responseDto = modelMapper.map(ParkingFloor, ParkingFloorResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{parkingFloorNumber}")
    public ResponseEntity<ParkingFloorResponseDto> getParkingFloorByNumber(@PathVariable("parkingFloorNumber")String parkingFloorNumber){
        ParkingFloor parkingFloor = parkingFloorService.getParkingFloorByNumber(parkingFloorNumber);
        ParkingFloorResponseDto responseDto = modelMapper.map(parkingFloor, ParkingFloorResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/all/{parkingLotName}")
    public ResponseEntity<List<ParkingFloorResponseDto>> getAllParkingFloors(@PathVariable("parkingLotName") String parkingLotName){
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(parkingLotName);
        List<ParkingFloor> allParkingFloors = parkingFloorService.getAllParkingFloors(parkingLot.getId());
        List<ParkingFloorResponseDto> parkingFloorResponseDtoList = allParkingFloors.stream()
                .map(ParkingFloor -> modelMapper.map(ParkingFloor, ParkingFloorResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(parkingFloorResponseDtoList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ParkingFloorResponseDto> updateParkingFloor(@RequestBody ParkingFloorRequestDto request){
//        ParkingFloor ParkingFloor = ParkingFloorService.updateParkingFloor(request.getSlotNumber(), request.getVehicleType(), request.getParkingFloorStatus());
//        ParkingFloorResponseDto responseDto = modelMapper.map(ParkingFloor, ParkingFloorResponseDto.class);
//        return new ResponseEntity<>(responseDto, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/get/{vehicleType}")
    public ResponseEntity<List<ParkingFloorResponseDto>> getParkingFloorByStatus(@PathVariable("vehicleType")String vehicleType){
//        VehicleType vehicleTypeEnum = VehicleType.valueOf(vehicleType);
//        List<ParkingFloor> ParkingFloorsList = ParkingFloorService.getParkingFloorByVehicleType(vehicleTypeEnum);
//        List<ParkingFloorResponseDto> ParkingFloorResponseDtoList = ParkingFloorsList.stream()
//                .map(ParkingFloor -> modelMapper.map(ParkingFloor, ParkingFloorResponseDto.class))
//                .collect(Collectors.toList());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/delete/{ParkingFloorNumber}")
    public ResponseEntity<String> deleteParkingFloor(@PathVariable("ParkingFloorNumber")String ParkingFloorNumber){
//        ParkingFloorService.deleteParkingFloor(ParkingFloorNumber);
        return new ResponseEntity<>("Deleted Successfully !!!", HttpStatus.OK);
    }
}
