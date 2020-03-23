package com.Shop.GestBoutik.services;

import java.util.Optional;

public interface CharacteristicService {
	
	Optional<?> findById(Long id);
	
	Optional<?> findByLabel(String label);

}
