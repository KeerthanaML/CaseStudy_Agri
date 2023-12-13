package com.example.dealer.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dealers")
public class Dealer {
	@MongoId

	private String id;

	@NotBlank(message = "Name cannot be blank")
	private String name;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email cannot be blank")
	private String email;

	@NotBlank(message = "Password cannot be blank")
	private String password;
}