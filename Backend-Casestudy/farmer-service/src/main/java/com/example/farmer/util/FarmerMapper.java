package com.example.farmer.util;

import com.example.farmer.dto.FarmerDTO;
import com.example.farmer.model.Farmer;

public class FarmerMapper {

    public static FarmerDTO toDTO(Farmer farmer) {
        FarmerDTO dto = new FarmerDTO();
        dto.setId(farmer.getId());
        dto.setName(farmer.getName());
        dto.setEmail(farmer.getEmail());
        
        return dto;
    }

    public static Farmer toEntity(FarmerDTO dto) {
        Farmer farmer = new Farmer();
        farmer.setId(dto.getId());
        farmer.setName(dto.getName());
        farmer.setEmail(dto.getEmail());
        farmer.setPassword(dto.getPassword()); 
        return farmer;
    }
}
