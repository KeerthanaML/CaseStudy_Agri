package com.example.payment.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentRequest {
    private String farmerId;
    private String dealerId;
    private double amount;

    
}

