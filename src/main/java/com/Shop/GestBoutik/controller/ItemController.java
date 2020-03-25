package com.Shop.GestBoutik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.models.Item;
import com.Shop.GestBoutik.services.ItemService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping("/")
	public List<Item> listItems() {
		
		List<Item> items = itemService.findAll();
		
		return items;
	}
	
	//TODO: get an item by id
	
	@PostMapping("/create")
	public void createItem(@RequestParam(name = "designation") String designation) {
		
		itemService.create(designation);
	}
	
	@PostMapping("/update")
	public void updateItem(@RequestParam(name = "designation") String designation, 
							@RequestParam(name = "id") Long itemId) {
		
		itemService.update(itemId, designation);
	}
	
	@PostMapping("/delete")
	public void deleteItem(@RequestParam(name = "id") Long itemId) {
		
		itemService.delete(itemId);
	}
	
	
}
