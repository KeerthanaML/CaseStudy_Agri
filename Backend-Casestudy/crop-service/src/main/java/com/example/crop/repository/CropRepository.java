package com.example.crop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.crop.model.Crop;

@Repository
public interface CropRepository extends MongoRepository<Crop, String> {
    List<Crop> findByFarmerId(String farmerId);
    
}