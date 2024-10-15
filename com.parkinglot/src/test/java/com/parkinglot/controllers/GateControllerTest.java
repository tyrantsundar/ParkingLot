package com.parkinglot.controllers;

import com.parkinglot.dtos.request.GateRequestDto;
import com.parkinglot.dtos.response.GateResponseDto;
import com.parkinglot.entities.Gate;
import com.parkinglot.entities.GateStatus;
import com.parkinglot.entities.GateType;
import com.parkinglot.entities.ParkingLot;
import com.parkinglot.services.GateService;
import com.parkinglot.services.ParkingLotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GateControllerTest {

    @Mock
    private GateService gateService;

    @Mock
    private ParkingLotService parkingLotService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private GateController gateController;

    private GateRequestDto gateRequestDto;
    private Gate gate;
    private GateResponseDto gateResponseDto;
    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        gateRequestDto = new GateRequestDto();
        gateRequestDto.setGateNumber("G1");
        gateRequestDto.setGateType(GateType.ENTRY);
        gateRequestDto.setGateStatus(GateStatus.OPEN);
        gateRequestDto.setParkingLotName("Lot A");

        gate = new Gate();
        gate.setGateNumber("G1");

        gateResponseDto = new GateResponseDto();
        gateResponseDto.setGateNumber("G1");

        parkingLot = new ParkingLot();
        parkingLot.setName("Lot A");
    }

    @Test
    void testSaveGate() {
        when(parkingLotService.getParkingLotByName("Lot A")).thenReturn(parkingLot);
        when(gateService.saveGate(any(), any(), any(), any())).thenReturn(gate);
        when(modelMapper.map(gate, GateResponseDto.class)).thenReturn(gateResponseDto);

        ResponseEntity<GateResponseDto> response = gateController.saveGate(gateRequestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(gateResponseDto, response.getBody());
    }

    @Test
    void testGetGateByNumber() {
        when(gateService.getGateByNumber("G1")).thenReturn(gate);
        when(modelMapper.map(gate, GateResponseDto.class)).thenReturn(gateResponseDto);

        ResponseEntity<GateResponseDto> response = gateController.getGateByNumber("G1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gateResponseDto, response.getBody());
    }

    @Test
    void testGetAllGates() {
        List<Gate> gates = Arrays.asList(gate);
        List<GateResponseDto> gateResponseDtoList = Arrays.asList(gateResponseDto);

        when(gateService.getAllGates()).thenReturn(gates);
        when(modelMapper.map(gate, GateResponseDto.class)).thenReturn(gateResponseDto);

        ResponseEntity<List<GateResponseDto>> response = gateController.getAllGates();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gateResponseDtoList, response.getBody());
    }

    @Test
    void testDeleteGate() {
        ResponseEntity<String> response = gateController.deleteGate("G1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Deleted Successfully !!!", response.getBody());
    }
}

