package com.parkinglot.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperatorResponseDto {
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
