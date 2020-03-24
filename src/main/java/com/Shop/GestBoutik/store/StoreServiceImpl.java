package com.Shop.GestBoutik.store;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Store;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	
	
	

	
	
//	PARSE MODEL TO DTO
	public StoreDto parseModelToDto(Store store) {
		
		StoreDto storeDto = new StoreDto();
		
		storeDto.setId(store.getId());
		storeDto.setDesignation(store.getDesignation());
		
		return storeDto;
	}
	
//	PARSE LIST MODEL TO DTO
	public Collection<StoreDto> parseListModelToDto(Collection<Store> stores) {
		
		Collection<StoreDto> storesDto = new ArrayList<StoreDto>();
		for (Store store : stores) {
			storesDto.add(parseModelToDto(store));
		}
		
		return storesDto;
	}
	
//	PARSE DTO TO MODEL
	public Store parseDtoToModel(StoreDto storeDto) {
		
		Store store = new Store();
		
		return store;
	}
	
	
	

}
