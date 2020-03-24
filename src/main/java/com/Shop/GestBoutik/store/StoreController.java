package com.Shop.GestBoutik.store;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.models.Store;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	
//	TODO: add method for search store by name
	
	@GetMapping("/")
	public List<StoreDto> listStores() {
		
		List<Store> stores = storeService.findAll();
		
		return (List<StoreDto>) storeService.parseListModelToDto(stores);
	}
	
	@GetMapping("/{storeId")
	public StoreDto storeDetail(@PathVariable("storeId") Long storeId) {
		
		StoreDto storeDto = new StoreDto();
		
		Optional<Store> storeOpt = storeService.findById(storeId);
		if (storeOpt.isPresent()) {
			storeDto = storeService.parseModelToDto(storeOpt.get());
		}
		else {
			System.out.println("User with id '" + storeId + "' not found");
		}
		
		return storeDto;
	}
	
	@PostMapping("/create")
	public void createStore(@RequestBody StoreDto storeDto) {
		
		storeService.create(storeDto);
	}
	
	@PostMapping("/delete")
	public void CancelStore(@RequestBody StoreDto storeDto) {
		
		storeService.delete(storeDto.getId());
		
	}
	
	@PutMapping(path = "{storeId}")
	public Store updateStore(@PathVariable("storeId") Long storeId, @RequestBody StoreDto storeDto) {
		
		return storeService.update(storeId, storeDto);
	}

}
