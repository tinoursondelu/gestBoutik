package com.Shop.GestBoutik.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Brand;
import com.Shop.GestBoutik.repository.BrandRepository;

@Service
public class BrandServiceImpl implements CharacteristicService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	

	@Override
	public Optional<Brand> findById(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public Optional<Brand> findByLabel(String label) {
		return brandRepository.findByLabel(label);
	}



}
