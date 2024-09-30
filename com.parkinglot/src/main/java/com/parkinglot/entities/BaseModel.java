package com.parkinglot.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BaseModel {
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
