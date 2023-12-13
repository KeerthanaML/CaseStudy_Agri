package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.payment.model.PaymentTransaction;
import com.example.payment.service.PaymentService;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("http://localhost:4200")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentTransaction> processPayment(@RequestBody PaymentTransaction paymentRequest) {
        PaymentTransaction paymentTransaction = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(paymentTransaction);
    }


}



