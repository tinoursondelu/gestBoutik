package com.Shop.GestBoutik.services;

import com.Shop.GestBoutik.models.Size;

import java.util.Optional;

public interface CharacteristicService {
	
	Optional<?> findById(Long id);
	
	Optional<?> findByLabel(String label);

}
