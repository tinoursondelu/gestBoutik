package com.Shop.GestBoutik.shelve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.models.Shelve;

@RestController
@RequestMapping("/shelve")
public class ShelveController {
	
	@Autowired
	private ShelveService shelveService;
	
	
	
	@GetMapping("/all/{storeId}")
	public List<ShelveDto> listShelveByStore(@PathVariable("storeId") Long storeId) {
		
		List<Shelve> shelves = shelveService.findAllByStoreId(storeId);
		
		return (List<ShelveDto>) shelveService.parseListModelToDto(shelves);
		
	}
	
	@GetMapping("/{shelveId}")
	public ShelveDto shelveDetail(@PathVariable("shelveId") Long shelveId) {
		
		ShelveDto shelveDto = new ShelveDto();
		
		Optional<Shelve> shelveOpt = shelveService.findById(shelveId);
		if (shelveOpt.isPresent()) {
			
			shelveDto = shelveService.parseModelToDto(shelveOpt.get());
			
		} else {
			System.out.println("Shelve with id '" + shelveId + "' not found");
		}
		return shelveDto;
	}

	@PostMapping("/create") 
	public void createShelve(@RequestBody ShelveDto shelveDto) {
		
		shelveService.create(shelveDto);
	}
	
	@PutMapping(path = "{shelveId}")
	public Shelve updateShelve(@PathVariable("shelveId") Long shelveId, @RequestBody ShelveDto shelveDto) {
		
		return shelveService.update(shelveId, shelveDto);
	}
	
	@DeleteMapping("/delete")
	public void deleteShelve(@RequestBody ShelveDto shelveDto) {
		
		shelveService.delete(shelveDto.getId());
	}
	
}
