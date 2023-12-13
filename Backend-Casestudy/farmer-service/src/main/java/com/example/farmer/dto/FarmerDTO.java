package com.example.farmer.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;


@Data
public class FarmerDTO {

    private String id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    
    @JsonIgnore
    @NotBlank(message = "Password cannot be blank")
    
    private String password; 
}