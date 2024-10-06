package com.parkinglot.services;

import com.parkinglot.entities.Operator;

import java.util.Optional;

public interface OperatorService {
    public Operator findByName(String name);
    public Operator saveOperator(String name);
}
