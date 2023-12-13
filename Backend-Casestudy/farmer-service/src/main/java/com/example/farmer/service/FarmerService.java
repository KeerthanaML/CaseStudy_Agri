package com.example.farmer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.example.farmer.exception.DuplicateEmailException;
import com.example.farmer.model.Farmer;
import com.example.farmer.repository.FarmerRepository;

@Service
public class FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;

	public List<Farmer> getAllFarmers() {
		return farmerRepository.findAll();
	}

	public Farmer getFarmerById(String id) {
		return farmerRepository.findById(id).orElse(null);
	}

	public Farmer createFarmer(Farmer farmer) {
		Optional<Farmer> existingFarmer = farmerRepository.findByEmail(farmer.getEmail());
		if (existingFarmer.isPresent()) {
			throw new DuplicateEmailException("Email already exists.");
		}
		return farmerRepository.save(farmer);
	}

	public Farmer updateFarmer(Farmer farmer) {
		return farmerRepository.save(farmer);
	}

	public Farmer deleteFarmer(String id) {
		Optional<Farmer> optionalFarmer = farmerRepository.findById(id);
		if (optionalFarmer.isPresent()) {
			farmerRepository.deleteById(id);
			return optionalFarmer.get();
		}
		return null;
	}
}
