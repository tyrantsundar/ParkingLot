package com.parkinglot.controllers;

import com.parkinglot.dtos.request.TicketRequestDto;
import com.parkinglot.dtos.response.TicketResponseDto;
import com.parkinglot.entities.*;
import com.parkinglot.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;
    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSlotService parkingSlotService;
    private ParkingFloorService parkingFloorService;
    private ParkingLotService parkingLotService;
    private VehicleOwnerService vehicleOwnerService;
    private OperatorService operatorService;
    private ModelMapper modelMapper;

    public TicketController(TicketService ticketService, VehicleService vehicleService, GateService gateService,
                            ParkingSlotService parkingSlotService, ParkingFloorService parkingFloorService,
                            ParkingLotService parkingLotService, VehicleOwnerService vehicleOwnerService,
                            OperatorService operatorService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.parkingSlotService = parkingSlotService;
        this.parkingFloorService = parkingFloorService;
        this.parkingLotService = parkingLotService;
        this.vehicleOwnerService = vehicleOwnerService;
        this.operatorService = operatorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/issue")
    public ResponseEntity<TicketResponseDto> issueTicket(@RequestBody TicketRequestDto request){

        Gate gate = gateService.getGateByNumber(request.getGateNumber());
        Vehicle vehicle = vehicleService.getVehicleByRegisterNumber(request.getVehicleNumber());
        ParkingLot parkingLot = parkingLotService.getParkingLotByName(request.getParkingLotName());
        VehicleType vehicleType = request.getVehicleType();
        Operator operator = operatorService.findByName(request.getOperatorName());

        Ticket ticket = ticketService.issueTicket(vehicle, operator, gate, parkingLot);
        TicketResponseDto responseDto = modelMapper.map(ticket, TicketResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{ticketId}")
    public ResponseEntity<TicketResponseDto> getTicket(@PathVariable("ticketId") int ticketId){
        Ticket ticket = ticketService.getTicketById(ticketId);
        TicketResponseDto responseDto = modelMapper.map(ticket, TicketResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
