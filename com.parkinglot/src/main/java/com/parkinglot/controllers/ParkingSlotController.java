package com.parkinglot.controllers;

import com.parkinglot.dtos.request.ParkingSlotRequestDto;
import com.parkinglot.dtos.response.ParkingSlotResponseDto;
import com.parkinglot.entities.ParkingSlot;
import com.parkinglot.entities.VehicleType;
import com.parkinglot.services.ParkingSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parkingSlot")
public class ParkingSlotController {
    private ParkingSlotService parkingSlotService;
    private ModelMapper modelMapper;
    
    ParkingSlotController(ParkingSlotService parkingSlotService, ModelMapper modelMapper){
        this.parkingSlotService = parkingSlotService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/save")
    public ResponseEntity<ParkingSlotResponseDto> saveParkingSlot(@RequestBody ParkingSlotRequestDto request){
        ParkingSlot parkingSlot = parkingSlotService.saveParkingSlot(request.getSlotNumber(), request.getVehicleType(), request.getParkingSlotStatus());
        ParkingSlotResponseDto responseDto = modelMapper.map(parkingSlot, ParkingSlotResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{parkingSlotNumber}")
    public ResponseEntity<ParkingSlotResponseDto> getParkingSlotByNumber(@PathVariable("parkingSlotNumber")String parkingSlotNumber){
        ParkingSlot parkingSlot = parkingSlotService.getParkingSlotByNumber(parkingSlotNumber);
        ParkingSlotResponseDto responseDto = modelMapper.map(parkingSlot, ParkingSlotResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingSlotResponseDto>> getAllParkingSlots(){
        List<ParkingSlot> allParkingSlots = parkingSlotService.getAllParkingSlots();
        List<ParkingSlotResponseDto> ParkingSlotResponseDtoList = allParkingSlots.stream()
                .map(ParkingSlot -> modelMapper.map(ParkingSlot, ParkingSlotResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(ParkingSlotResponseDtoList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ParkingSlotResponseDto> updateParkingSlot(@RequestBody ParkingSlotRequestDto request){
        ParkingSlot parkingSlot = parkingSlotService.updateParkingSlot(request.getSlotNumber(), request.getVehicleType(), request.getParkingSlotStatus());
        ParkingSlotResponseDto responseDto = modelMapper.map(parkingSlot, ParkingSlotResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{vehicleType}")
    public ResponseEntity<List<ParkingSlotResponseDto>> getParkingSlotByStatus(@PathVariable("vehicleType")String vehicleType){
        VehicleType vehicleTypeEnum = VehicleType.valueOf(vehicleType);
        List<ParkingSlot> ParkingSlotsList = parkingSlotService.getParkingSlotByVehicleType(vehicleTypeEnum);
        List<ParkingSlotResponseDto> ParkingSlotResponseDtoList = ParkingSlotsList.stream()
                .map(ParkingSlot -> modelMapper.map(ParkingSlot, ParkingSlotResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(ParkingSlotResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete/{parkingSlotNumber}")
    public ResponseEntity<String> deleteParkingSlot(@PathVariable("parkingSlotNumber")String parkingSlotNumber){
        parkingSlotService.deleteParkingSlot(parkingSlotNumber);
        return new ResponseEntity<>("Deleted Successfully !!!", HttpStatus.OK);
    }

}
