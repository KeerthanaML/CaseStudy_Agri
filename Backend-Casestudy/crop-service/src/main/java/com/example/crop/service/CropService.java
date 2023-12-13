package com.example.crop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crop.model.Crop;
import com.example.crop.repository.CropRepository;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;

 

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

 

    public List<Crop> getCropsByFarmer(String farmerId) {
        return cropRepository.findByFarmerId(farmerId);
    }

 

    public Crop getCropById(String id) {
        return cropRepository.findById(id).orElse(null);
    }

 

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

 

    public Crop updateCrop(Crop crop) {
        return cropRepository.save(crop);
    }

 

    public void deleteCrop(String id) {
        cropRepository.deleteById(id);
    }
}
