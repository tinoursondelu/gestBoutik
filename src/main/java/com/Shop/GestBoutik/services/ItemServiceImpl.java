package com.Shop.GestBoutik.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.dto.ItemDto;
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
	public void create(ItemDto itemDto) {

		Item item = new Item();
		
		item = parseDtoToModel(itemDto);
		
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
	public Item update(ItemDto itemDto) {

		Item item = new Item();

		Optional<Item> itemOpt = findById(itemDto.getId());
		
		if (itemOpt.isPresent()) {
			item = parseDtoToModel(itemDto);
			
			if(!exists(item)) {
				try {
					itemRepository.save(item);
				} catch (Exception e) {
					System.out.println(e.getCause());
				}
			}
			else {
				System.out.println("This item designation doesn't exist");
			}
		} 
		
		return item;
	}

	@Override
	public void delete(Long id) {

		Optional<Item> itemOpt = findById(id);
		
		if (itemOpt.isPresent()) {
			itemRepository.delete(itemOpt.get());
			
			try {
				itemRepository.delete(itemOpt.get());
			} catch (Exception e) {
				System.out.println("Fail to delete this item");
			}
		}
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	@Override
	public boolean exists(Item item) {
		
		Optional<Item> itemOpt = itemRepository.findByDesignation(item.getDesignation());
		
		return itemOpt.isPresent();
	}
	
	@Override
	public ItemDto parseModelToDto(Item item) {

		ItemDto itemDto = new ItemDto();

		itemDto.setId(item.getId());
		itemDto.setDesignation(item.getDesignation());

		return itemDto;
	}

	@Override
	public Collection<ItemDto> parseListModelToDto(Collection<Item> items) {

		Collection<ItemDto> itemsDto = new ArrayList<ItemDto>();
		for (Item item : items) {
			itemsDto.add(parseModelToDto(item));
		}

		return itemsDto;
	}

	@Override
	public Item parseDtoToModel(ItemDto itemDto) {

		Item item = new Item();

		item.setId(itemDto.getId());
		item.setDesignation(itemDto.getDesignation());

		return item;
	}
	
}