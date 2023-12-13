package com.example.farmer.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.farmer.model.Farmer;

 
@Repository
public interface FarmerRepository extends MongoRepository<Farmer, String> { 
	Optional<Farmer> findByEmail(String email);
}
