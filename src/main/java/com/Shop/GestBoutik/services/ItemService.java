package com.Shop.GestBoutik.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Shop.GestBoutik.dto.ItemDto;
import com.Shop.GestBoutik.models.Item;

public interface ItemService {
	
	List<Item> findAll();
	
	Optional<?> findById(Long id);
	
	Optional<?> findByDesignation(String designation);
	
	void create(ItemDto itemDto);
	
	Item update(ItemDto itemDto);
	
	void delete(Long itemId);

	boolean exists(Item item);

	ItemDto parseModelToDto(Item item);

	Collection<ItemDto> parseListModelToDto(Collection<Item> items);

	Item parseDtoToModel(ItemDto itemDto);

	

	
	
}