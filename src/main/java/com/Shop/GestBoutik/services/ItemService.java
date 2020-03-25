package com.Shop.GestBoutik.services;

import java.util.List;
import java.util.Optional;
import com.Shop.GestBoutik.models.Item;

public interface ItemService {
	
	List<Item> findAll();
	
	Optional<?> findById(Long id);
	
	Optional<?> findByDesignation(String designation);
	
	void create(String designation);

	void delete(Long itemId);

	void update(Long id, String designation);
}