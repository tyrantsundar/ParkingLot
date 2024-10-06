package com.parkinglot.services.impl;

import com.parkinglot.entities.Operator;
import com.parkinglot.exception.notFound.OperatorNotFoundException;
import com.parkinglot.repositories.OperatorRepository;
import com.parkinglot.services.OperatorService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OperatorServiceImpl implements OperatorService {
    private OperatorRepository operatorRepository;

    public OperatorServiceImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public Operator findByName(String name) {
        Optional<Operator> operatorOptional = operatorRepository.findByName(name);
        if(operatorOptional.isEmpty()){
            throw new OperatorNotFoundException(name,"OPERATOR-Name");
        }
        return operatorOptional.get();
    }

    @Override
    public Operator saveOperator(String name) {
        Operator operator = new Operator(name);
        Date currDate = new Date();
        operator.setCreatedAt(currDate);
        operator.setUpdatedAt(currDate);
        Operator savedOperator = operatorRepository.save(operator);
        return savedOperator;
    }
}
