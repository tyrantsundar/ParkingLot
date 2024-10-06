package com.parkinglot.controllers;

import com.parkinglot.dtos.request.VehicleOwnerRequestDto;
import com.parkinglot.dtos.request.VehicleRequestDto;
import com.parkinglot.dtos.response.VehicleOwnerResponseDto;
import com.parkinglot.dtos.response.VehicleResponseDto;
import com.parkinglot.entities.Vehicle;
import com.parkinglot.entities.VehicleOwner;
import com.parkinglot.services.VehicleOwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicleOwner")
public class VehicleOwnerController {
    private VehicleOwnerService vehicleOwnerService;
    private ModelMapper modelMapper;

    public VehicleOwnerController(VehicleOwnerService vehicleOwnerService, ModelMapper modelMapper) {
        this.vehicleOwnerService = vehicleOwnerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<VehicleOwnerResponseDto> saveVehicleOwner(@RequestBody VehicleOwnerRequestDto request){
        VehicleOwner vehicleOwner = vehicleOwnerService.saveVehicleOwner(request.getName(), request.getMobile(), request.getMail());
        VehicleOwnerResponseDto response = modelMapper.map(vehicleOwner, VehicleOwnerResponseDto.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get/{mobile}")
    public ResponseEntity<VehicleOwnerResponseDto> getVehicleOwnerByRegisterNumber(@PathVariable("mobile") String mobile){
        VehicleOwner vehicleOwner = vehicleOwnerService.getVehicleOwnerByMobile(mobile);
        VehicleOwnerResponseDto responseDto = modelMapper.map(vehicleOwner, VehicleOwnerResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
