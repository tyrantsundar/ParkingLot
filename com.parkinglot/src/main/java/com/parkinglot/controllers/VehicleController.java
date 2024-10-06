package com.parkinglot.controllers;

import com.parkinglot.dtos.request.VehicleRequestDto;
import com.parkinglot.dtos.response.VehicleResponseDto;
import com.parkinglot.entities.Vehicle;
import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.services.VehicleOwnerService;
import com.parkinglot.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private VehicleService vehicleService;
    private VehicleOwnerService vehicleOwnerService;
    private ModelMapper modelMapper;

    public VehicleController(VehicleService vehicleService, VehicleOwnerService vehicleOwnerService, ModelMapper modelMapper) {
        this.vehicleService = vehicleService;
        this.vehicleOwnerService = vehicleOwnerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<VehicleResponseDto> saveVehicle(@RequestBody VehicleRequestDto request){
        VehicleOwner vehicleOwner = vehicleOwnerService.getVehicleOwnerByMobile(request.getVehicleOwnerMobile());
        Vehicle vehicle = vehicleService.saveVehicle(request.getRegisterNumber(), request.getVehicleType(), vehicleOwner);
        VehicleResponseDto responseDto = modelMapper.map(vehicle, VehicleResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{registerNumber}")
    public ResponseEntity<VehicleResponseDto> getVehicleByRegisterNumber(@PathVariable("registerNumber") String registerNumber){
        Vehicle vehicle = vehicleService.getVehicleByRegisterNumber(registerNumber);
        VehicleResponseDto responseDto = modelMapper.map(vehicle, VehicleResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
