package com.Shop.GestBoutik.shelve;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.Shop.GestBoutik.models.Shelve;

public interface ShelveService {
	
	
//	METHODS
	public ShelveDto parseModelToDto(Shelve shelve);
	
	public Collection<ShelveDto> parseListModelToDto(Collection<Shelve> shelves);
	
	public Shelve parseDtoToModel(ShelveDto shelveDto);

	
//	DATA BASE
	public Optional<Shelve> findById(Long id);
	
	public List<Shelve> findAll();

}
