package com.example.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.payment.model.PaymentTransaction;

public interface PaymentRepository extends MongoRepository<PaymentTransaction, String> {
}


