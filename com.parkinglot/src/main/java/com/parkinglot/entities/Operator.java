package com.parkinglot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "operator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operator extends BaseModel{
    private String name;
}
