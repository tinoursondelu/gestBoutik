package com.Shop.GestBoutik.store;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Shop.GestBoutik.models.Store;

public interface StoreService {

	Optional<Store> findById(Long id);

	List<Store> findAll();


	//	METHODS
	public void create(String designation);

	public void create(StoreDto storeDto);

	public Store update(Long id, StoreDto storeDto);
	
	public void delete(Long id);

	public StoreDto parseModelToDto(Store store);

	public Collection<StoreDto> parseListModelToDto(Collection<Store> stores);

	public Store parseDtoToModel(StoreDto storeDto);

}
