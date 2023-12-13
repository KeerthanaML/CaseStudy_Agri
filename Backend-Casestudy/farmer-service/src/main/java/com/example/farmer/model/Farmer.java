 package com.example.farmer.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "farmers")
public class Farmer {
    @Id
    private String id;

    @NotEmpty(message = "Name cannot be blank")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    @Indexed(unique = true)
    private String email;
    
    @NotBlank(message = "Password cannot be blank")
    private String password;
}


