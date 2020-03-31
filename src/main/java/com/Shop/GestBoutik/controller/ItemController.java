package com.Shop.GestBoutik.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.dto.ItemDto;
import com.Shop.GestBoutik.models.Item;
import com.Shop.GestBoutik.services.ItemService;


@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping("/all")
	public List<ItemDto> listItems() {
		
		List<Item> items = itemService.findAll();
		
		return (List<ItemDto>) itemService.parseListModelToDto(items);
	}
	
	@GetMapping("/{itemId}")
	public ItemDto itemDetails(@PathVariable("itemId") Long itemId) {

		ItemDto itemDto = new ItemDto();

		Optional<Item> itemOpt = (Optional<Item>) itemService.findById(itemId);
		if (itemOpt.isPresent()) {

			itemDto = itemService.parseModelToDto(itemOpt.get());

		} else {
			System.out.println("Item with id '" + itemId + "' not found");
		}
		
		return itemDto;
	}

	@PostMapping("/create")
	public void createItem(@RequestBody ItemDto itemDto) {
		
		itemService.create(itemDto);
	}
	
	@PostMapping("/update")
	public ItemDto updateItem(@RequestBody ItemDto itemDto) {
		
		return itemService.parseModelToDto(itemService.update(itemDto));
	}
	
	@PostMapping("/delete")
	public void deleteItem(@RequestBody ItemDto itemDto) {
		
		itemService.delete(itemDto.getId());
	}
}
