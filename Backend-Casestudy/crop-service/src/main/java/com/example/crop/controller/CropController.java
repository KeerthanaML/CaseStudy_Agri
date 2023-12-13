package com.example.crop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crop.model.Crop;
import com.example.crop.service.CropService;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin("http://localhost:4200")
public class CropController {
    @Autowired
    private CropService cropService;

 

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

 

    @GetMapping("/farmer/{farmerId}")
    public List<Crop> getCropsByFarmer(@PathVariable String farmerId) {
        return cropService.getCropsByFarmer(farmerId);
    }

 

    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable String id) {
        return cropService.getCropById(id);
    }

 

    @PostMapping
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

 

    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable String id, @RequestBody Crop crop) {
        crop.setCropId(id);
        return cropService.updateCrop(crop);
    }

 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable String id) {
        cropService.deleteCrop(id);
        return ResponseEntity.ok("deleted");
    }
    
}
