package com.example.farmer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.when;

 

import com.example.farmer.controller.FarmerController;

import com.example.farmer.dto.FarmerDTO;

import com.example.farmer.model.Farmer;

import com.example.farmer.service.FarmerService;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

import java.util.List;
@ExtendWith(MockitoExtension.class)

class FarmerServiceApplicationTests {

 

    @InjectMocks

    private FarmerController farmerController;

 

    @Mock

    private FarmerService farmerService;

 

    @Test

    public void testGetAllFarmers() {

   

        List<Farmer> farmers = Arrays.asList(

            new Farmer("11", "keerthi", "keerthi12@gmail.com", "keerthi@123"),

            new Farmer("7", "ramya", "ramya1234@gmail.com", "ramya@123")

        );

 

        when(farmerService.getAllFarmers()).thenReturn(farmers);

        List<FarmerDTO> farmerDTOs = farmerController.getAllFarmers();

        assertNotNull(farmerDTOs);

        assertEquals(2, farmerDTOs.size());

    }

 

    @Test

    public void testGetFarmerById() {

        Farmer sampleFarmer = new Farmer("11", "keerthi", "keerthi12@gmail.com", "keerthi@123");

        when(farmerService.getFarmerById("11")).thenReturn(sampleFarmer);

        ResponseEntity<?> response = farmerController.getFarmerById("11");

 

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        FarmerDTO farmerDTO = (FarmerDTO) response.getBody();

        assertNotNull(farmerDTO);

        assertEquals("11", farmerDTO.getId());    

    }

 

    @Test

    public void testCreateFarmer() {   

        Farmer sampleFarmer = new Farmer("7", "ramya", "ramya1234@gmail.com", "ramya@123");

        when(farmerService.createFarmer(sampleFarmer)).thenReturn(sampleFarmer);

        ResponseEntity<FarmerDTO> response = farmerController.createFarmer(sampleFarmer);

       

        assertNotNull(response);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        FarmerDTO farmerDTO = response.getBody();

        assertNotNull(farmerDTO);

        assertEquals("7", farmerDTO.getId());

    }

 

    @Test

    public void testDeleteFarmer() {

        Farmer sampleFarmer = new Farmer("7", "ramya", "ramya1234@gmail.com", "ramya@123");

        when(farmerService.deleteFarmer("11")).thenReturn(sampleFarmer);

        ResponseEntity<?> response = farmerController.deleteFarmer("11");

 

        assertNotNull(response);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals("Farmer deleted", response.getBody());       

    }

}