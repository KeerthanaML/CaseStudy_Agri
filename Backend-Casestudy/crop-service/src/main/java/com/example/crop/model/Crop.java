package com.example.crop.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@AllArgsConstructor

@Document(collection = "crops") 

public class Crop {

	@Id

	private String cropId;
	
	private String imageUrl;

	@NotBlank(message = "Farmer ID cannot be blank")

	private String farmerId;

	@NotBlank(message = "Type cannot be blank")

	private String cropType;

	@NotBlank(message = "Name cannot be blank")

	private String cropName;

	@NotNull(message = "Quantity cannot be null")

	@Min(value = 0, message = "Quantity must be greater than or equal to 0")

	private Double quantity;
	
	
	@NotBlank(message = "Price cannot be blank")
	private Integer price;

	@NotBlank(message = "Location cannot be blank")
	
	private String location;
	
	

}