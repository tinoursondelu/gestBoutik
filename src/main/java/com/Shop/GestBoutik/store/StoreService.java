package com.Shop.GestBoutik.store;

import java.util.Optional;

import com.Shop.GestBoutik.models.Store;

public interface StoreService {
	
	Optional<Store> findById(Long id);

}
