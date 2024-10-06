package com.parkinglot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle_owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleOwner extends BaseModel{
    private String name;
    private String mobile;
    private String mail;
}
