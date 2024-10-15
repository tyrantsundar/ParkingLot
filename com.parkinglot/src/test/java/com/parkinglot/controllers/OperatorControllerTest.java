package com.parkinglot.controllers;

import com.parkinglot.dtos.request.OperatorRequestDto;
import com.parkinglot.dtos.response.OperatorResponseDto;
import com.parkinglot.entities.Operator;
import com.parkinglot.exception.invalid.InvalidOperatorException;
import com.parkinglot.exception.notFound.OperatorNotFoundException;
import com.parkinglot.services.OperatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperatorControllerTest {
    @Mock
    private OperatorService operatorService;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private OperatorController operatorController;

    private OperatorRequestDto operatorRequestDto;
    private Operator operator;
    private OperatorResponseDto operatorResponseDto;

    @BeforeEach
    void setUp(){
        operatorRequestDto = new OperatorRequestDto();
        operatorRequestDto.setName("OP 1");

        operator = new Operator();
        operator.setName("OP 1");

        operatorResponseDto = new OperatorResponseDto();
        operatorResponseDto.setName("OP 1");
    }

    @Test
    void saveOperator(){
        when(operatorService.saveOperator(operatorRequestDto.getName())).thenReturn(operator);
        when(modelMapper.map(operator, OperatorResponseDto.class)).thenReturn(operatorResponseDto);

        ResponseEntity<OperatorResponseDto> response = operatorController.saveOperator(operatorRequestDto);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertEquals(operatorResponseDto,response.getBody());
    }

    @Test
    void saveOperator_NullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            operatorController.saveOperator(null);
        });
    }

    @Test
    void saveOperator_EmptyName() {
        operatorRequestDto.setName("");
        assertThrows(InvalidOperatorException.class, () -> {
            operatorController.saveOperator(operatorRequestDto);
        });
    }

    @Test
    void saveOperator_AlreadyExists() {
        when(operatorService.saveOperator(operatorRequestDto.getName())).thenThrow(new InvalidOperatorException("Operator already exists"));
        assertThrows(InvalidOperatorException.class, () -> {
            operatorController.saveOperator(operatorRequestDto);
        });
    }

    @Test
    void saveOperator_InvalidName() {
        operatorRequestDto.setName("Invalid Name@");
        assertThrows(InvalidOperatorException.class, () -> {
            operatorController.saveOperator(operatorRequestDto);
        });
    }

    @Test
    void getOperatorByName(){
        when(operatorService.findByName("OP 1")).thenReturn(operator);
        when(modelMapper.map(operator, OperatorResponseDto.class)).thenReturn(operatorResponseDto);

        ResponseEntity<OperatorResponseDto> response = operatorController.findOperatorByName("OP 1");
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(operatorResponseDto,response.getBody());
    }

    @Test
    void getOperatorByName_NOT_FOUND(){
        String operatorName = "OP 1";
        when(operatorService.findByName(operatorName)).thenThrow(new OperatorNotFoundException(operatorName));
        assertThrows(OperatorNotFoundException.class, () -> {
            operatorController.findOperatorByName(operatorName);
        });
    }

}

