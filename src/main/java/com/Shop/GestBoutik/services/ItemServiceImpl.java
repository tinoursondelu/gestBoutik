package com.Shop.GestBoutik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Item;
import com.Shop.GestBoutik.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Optional<Item> findById(Long id) {
		
		return itemRepository.findById(id);
	}

	@Override
	public Optional<Item> findByDesignation(String designation) {
		
		return itemRepository.findByDesignation(designation);
	}
	
	@Override
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	@Override
	public void create(String designation) {

		Item item = new Item();

		item.setDesignation(designation);
		
		if (!exists(item)) {

			try {
				itemRepository.save(item);
			} catch (Exception e) {
				System.out.println(e.getCause());
			}
		} else {
			System.out.println("This item designation already exists");
		}
	}
	
	@Override
	public void update(Long id, String designation) {

		Item item = new Item();
		item.setId(id);
		item.setDesignation(designation);

		Optional<Item> itemOpt = findById(id);
		if (itemOpt.isPresent()) {
			itemRepository.save(item);
		} else {
			System.out.println("This item designation doesn't exist");
		}
	}
	
	@Override
	public void delete(Long id) {

		Optional<Item> itemOpt = findById(id);
		if (itemOpt.isPresent()) {
			itemRepository.delete(itemOpt.get());
		}
	}
	
	public boolean exists(Item item) {
		
		Optional<Item> itemOpt = itemRepository.findByDesignation(item.getDesignation());
		
		return itemOpt.isPresent();
	}
}