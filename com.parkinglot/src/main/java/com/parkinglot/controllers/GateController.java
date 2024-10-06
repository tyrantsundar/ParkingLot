package com.parkinglot.controllers;

import com.parkinglot.dtos.request.GateRequestDto;
import com.parkinglot.dtos.response.GateResponseDto;
import com.parkinglot.entities.Gate;
import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.ParkingLot;
import com.parkinglot.services.GateService;
import com.parkinglot.services.ParkingLotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gate")
public class GateController {

    private GateService gateService;
    private ParkingLotService parkingLotService;
    private ModelMapper modelMapper;

    GateController(GateService gateService, ParkingLotService parkingLotService, ModelMapper modelMapper){
        this.gateService = gateService;
        this.parkingLotService = parkingLotService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<GateResponseDto> saveGate(@RequestBody GateRequestDto request){
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(request.getParkingLotName());
        Gate gate = gateService.saveGate(request.getGateNumber(), request.getGateType(), request.getGateStatus(),parkingLot);
        GateResponseDto responseDto = modelMapper.map(gate, GateResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{gateNumber}")
    public ResponseEntity<GateResponseDto> getGateByNumber(@PathVariable("gateNumber")String gateNumber){
        Gate gate = gateService.getGateByNumber(gateNumber);
        GateResponseDto responseDto = modelMapper.map(gate, GateResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<GateResponseDto>> getAllGates(){
        List<Gate> allGates = gateService.getAllGates();
        List<GateResponseDto> gateResponseDtoList = allGates.stream()
                .map(gate -> modelMapper.map(gate, GateResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(gateResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<GateResponseDto> updateGate(@RequestBody GateRequestDto request){
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(request.getParkingLotName());
        Gate gate = gateService.updateGate(request.getGateNumber(), request.getGateType(), request.getGateStatus(),parkingLot);
        GateResponseDto responseDto = modelMapper.map(gate, GateResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/status/{gateStatus}")
    public ResponseEntity<List<GateResponseDto>> getGateByStatus(@PathVariable("gateStatus")String gateStatus){
        GateStatus gateStatusEnum = GateStatus.valueOf(gateStatus);
        List<Gate> gatesList = gateService.getGateByStatus(gateStatusEnum);
        List<GateResponseDto> gateResponseDtoList = gatesList.stream()
                .map(gate -> modelMapper.map(gate, GateResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(gateResponseDtoList, HttpStatus.OK);
    }

    @PostMapping("/delete/{gateNumber}")
    public ResponseEntity<String> deleteGate(@PathVariable("gateNumber")String gateNumber){
        gateService.deleteGate(gateNumber);
        return new ResponseEntity<>("Deleted Successfully !!!", HttpStatus.OK);
    }

}
