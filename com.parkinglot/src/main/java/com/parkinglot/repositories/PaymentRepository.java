package com.parkinglot.repositories;

import com.parkinglot.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    public Optional<Payment> findByRefNumber(String refNumber);
}
