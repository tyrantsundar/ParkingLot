package com.parkinglot.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleOwnerRequestDto {
    private String name;
    private String mobile;
    private String mail;
}
