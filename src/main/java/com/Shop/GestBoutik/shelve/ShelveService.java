package com.Shop.GestBoutik.shelve;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Shop.GestBoutik.models.Shelve;
import com.Shop.GestBoutik.models.Store;

public interface ShelveService {
	
	
//	METHODS
	public void create(String designation, Store store);
	
	public void create(ShelveDto shelveDto);
	
	public Shelve update(Long id, ShelveDto shelveDto);
	
	public void delete(Long id);	
	
	public ShelveDto parseModelToDto(Shelve shelve);
	
	public Collection<ShelveDto> parseListModelToDto(Collection<Shelve> shelves);
	
	public Shelve parseDtoToModel(ShelveDto shelveDto);

	
//	DATA BASE
	public Optional<Shelve> findById(Long id);
	
	public List<Shelve> findAll();

}
