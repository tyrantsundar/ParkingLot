package com.parkinglot.controllers;

import com.parkinglot.dtos.request.BillRequestDto;
import com.parkinglot.dtos.response.BillResponseDto;
import com.parkinglot.entities.*;
import com.parkinglot.services.BillService;
import com.parkinglot.services.GateService;
import com.parkinglot.services.OperatorService;
import com.parkinglot.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {
    private BillService billService;
    private GateService gateService;
    private OperatorService operatorService;
    private TicketService ticketService;
    private ModelMapper modelMapper;

    public BillController(BillService billService, GateService gateService, OperatorService operatorService,
                          TicketService ticketService, ModelMapper modelMapper) {
        this.billService = billService;
        this.gateService = gateService;
        this.operatorService = operatorService;
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/doBill")
    public ResponseEntity<BillResponseDto> doBilling(@RequestBody BillRequestDto request){
        String gateNumber = request.getGateNumber();
        String operatorName = request.getOperatorName();
        String ticketId = request.getTicketId();
        PaymentMode paymentMode = request.getPaymentMode();
        String paymentCardDetail = request.getPaymentCardDetail();

        Gate exitGate = gateService.getGateByNumber(gateNumber);
        Operator operator = operatorService.findByName(operatorName);
        Ticket ticket = ticketService.getTicketById(Integer.parseInt(ticketId));

        Bill savedBill = billService.doBilling(exitGate, operator, ticket, paymentMode, paymentCardDetail);
        BillResponseDto responseDto = modelMapper.map(savedBill, BillResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{billingId}")
    public ResponseEntity<BillResponseDto> getBill(@PathVariable("billingId") int billingId){
        Bill bill = billService.getBill(billingId);
        BillResponseDto responseDto = modelMapper.map(bill, BillResponseDto.class);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
