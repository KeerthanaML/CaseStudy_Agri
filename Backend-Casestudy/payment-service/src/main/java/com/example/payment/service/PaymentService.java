package com.example.payment.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.model.PaymentTransaction;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

	public PaymentTransaction processPayment(PaymentTransaction paymentRequest) {
		String status = Math.random() < 0.8 ? "SUCCESS" : "FAILURE";
		paymentRequest.setStatus(status);
		return paymentRepository.save(paymentRequest);
	}
	
}




