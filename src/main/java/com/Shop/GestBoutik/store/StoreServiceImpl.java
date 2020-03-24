package com.Shop.GestBoutik.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Store;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public void create(String designation) {

		Store store = new Store();

		store.setDesignation(designation);
		storeRepository.save(store);
	}

	@Override
	public void create(StoreDto storeDto) {

		Store store = new Store();

		store = parseDtoToModel(storeDto);
		storeRepository.save(store);
	}

	@Override
	public Store update(Long id, StoreDto storeDto) {

		Store store = new Store();

		Optional<Store> storeOpt = findById(id);
		if (storeOpt.isPresent()) {
			store = parseDtoToModel(storeDto);
			storeRepository.save(store);
		}
		return store;
	}
	
	@Override
	public void delete(Long id) {
		
		Optional<Store> storeOpt = findById(id);
		if (storeOpt.isPresent()) {
			storeRepository.delete(storeOpt.get());
		}
	}



	//	PPPPPPP		AAA		RRRRRR	  SSSSSSS	EEEEEEE
	//	PP   PP	   AA AA	RR	 RR	  SS		EE
	//	PP   PP	  AA   AA	RR	 RR	  SS		EE
	//	PPPPPPP	  AAAAAAA	RRRRRR	  SSSSSSS	EEEEEE
	//	PP		  AA   AA	RRRR	   	   SS	EE
	//	PP		  AA   AA	RR	RR		   SS	EE
	//	PP		  AA   AA	RR   RR	  SSSSSSS	EEEEEEE


	//	PARSE MODEL TO DTO
	@Override
	public StoreDto parseModelToDto(Store store) {

		StoreDto storeDto = new StoreDto();

		storeDto.setId(store.getId());
		storeDto.setDesignation(store.getDesignation());

		return storeDto;
	}

	//	PARSE LIST MODEL TO DTO
	@Override
	public Collection<StoreDto> parseListModelToDto(Collection<Store> stores) {

		Collection<StoreDto> storesDto = new ArrayList<StoreDto>();
		for (Store store : stores) {
			storesDto.add(parseModelToDto(store));
		}

		return storesDto;
	}

	//	PARSE DTO TO MODEL
	@Override
	public Store parseDtoToModel(StoreDto storeDto) {

		Store store = new Store();

		store.setId(storeDto.getId());
		store.setDesignation(storeDto.getDesignation());

		return store;
	}

	//	DDDDD		BBBBBB
	//	DD  DD		BB   BB
	//	DD   DD		BB   BB
	//	DD   DD		BBBBBB
	//	DD   DD		BB   BB
	//	DD  DD		BB   BB
	//	DDDDD		BBBBBB

	@Override
	public Optional<Store> findById(Long id) {

		return storeRepository.findById(id);
	}

	@Override
	public List<Store> findAll() {
		
		return storeRepository.findAll();
	}




}
