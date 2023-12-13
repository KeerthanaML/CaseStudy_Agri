package com.example.farmer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;

import com.example.farmer.dto.FarmerDTO;
import com.example.farmer.exception.DuplicateEmailException;
import com.example.farmer.model.Farmer;
import com.example.farmer.service.FarmerService;
import com.example.farmer.util.FarmerMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/farmers")
@CrossOrigin("http://localhost:4200")
public class FarmerController {
    
    @Autowired
    private FarmerService farmerService;

    @GetMapping
    public List<FarmerDTO> getAllFarmers() {
        List<Farmer> farmers = farmerService.getAllFarmers();
        return farmers.stream().map(FarmerMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFarmerById(@PathVariable String id) {
        Farmer farmer = farmerService.getFarmerById(id);
        if(farmer != null) {
            return ResponseEntity.ok(FarmerMapper.toDTO(farmer));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmer not found");
    }

    @PostMapping
    public ResponseEntity<FarmerDTO> createFarmer(@Valid @RequestBody Farmer farmer) {
        Farmer savedFarmer = farmerService.createFarmer(farmer);
        return ResponseEntity.status(HttpStatus.CREATED).body(FarmerMapper.toDTO(savedFarmer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFarmer(@PathVariable String id, @Valid @RequestBody FarmerDTO farmerDTO) {
        Farmer farmer = FarmerMapper.toEntity(farmerDTO);
        farmer.setId(id);
        Farmer updatedFarmer = farmerService.updateFarmer(farmer);
        return new ResponseEntity<>(FarmerMapper.toDTO(updatedFarmer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFarmer(@PathVariable String id) {
        Farmer deletedFarmer = farmerService.deleteFarmer(id);
        if(deletedFarmer != null) {
            FarmerDTO deletedFarmerDTO = FarmerMapper.toDTO(deletedFarmer);
            return ResponseEntity.ok().body("Farmer deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmer not found");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<String> handleDuplicateEmailException(DuplicateEmailException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
