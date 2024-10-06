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
public class VehicleOwnerResponseDto {
    private int id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String mobile;
    private String mail;
}
