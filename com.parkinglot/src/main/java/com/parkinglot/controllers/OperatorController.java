package com.parkinglot.controllers;

import com.parkinglot.dtos.request.OperatorRequestDto;
import com.parkinglot.dtos.response.OperatorResponseDto;
import com.parkinglot.entities.Operator;
import com.parkinglot.services.OperatorService;
import jakarta.persistence.Table;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    private OperatorService operatorService;
    private ModelMapper modelMapper;

    public OperatorController(OperatorService operatorService, ModelMapper modelMapper) {
        this.operatorService = operatorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<OperatorResponseDto> saveOperator(@RequestBody OperatorRequestDto request){
        Operator operator = operatorService.saveOperator(request.getName());
        OperatorResponseDto responseDto = modelMapper.map(operator, OperatorResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<OperatorResponseDto> findOperatorByName(@PathVariable("name") String name){
        Operator operator = operatorService.findByName(name);
        OperatorResponseDto responseDto = modelMapper.map(operator, OperatorResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
