package com.example.payment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payment")
public class PaymentTransaction {
	 @Id
	    private String id;

//	    @NotBlank(message = "Farmer ID cannot be blank")
//	    private String farmerId;
//
//	    @NotBlank(message = "Dealer ID cannot be blank")
//	    private String dealerId;

	 	@NotBlank(message = "Card name cannot be blank")
	    private String cardName;
	 	
	 	@NotBlank(message = "Card number cannot be blank")
	    private String cardNo;
	 
	    @NotNull(message = "Amount cannot be null")
	    @Positive(message = "Amount must be a positive number")
	    private double amount;

	    @NotBlank(message = "Status cannot be blank")
	    private String status;
}

//cardname, cardno
//orderid farmerid dealerid cropname