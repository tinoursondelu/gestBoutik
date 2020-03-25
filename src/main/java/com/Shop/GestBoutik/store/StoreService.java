package com.Shop.GestBoutik.store;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Shop.GestBoutik.models.Store;

public interface StoreService {

	//	METHODS
	public void create(String designation);

	public void create(StoreDto storeDto);

	public Store update(StoreDto storeDto);
	
	public void delete(Long id);

	public StoreDto parseModelToDto(Store store);

	public Collection<StoreDto> parseListModelToDto(Collection<Store> stores);

	public Store parseDtoToModel(StoreDto storeDto);
	
	
//	DATA BASE
	Optional<Store> findById(Long id);

	List<Store> findAll();

}
