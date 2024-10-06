package com.parkinglot.repositories;

import com.parkinglot.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Integer> {
    public Optional<Operator> findByName(String name);
}
