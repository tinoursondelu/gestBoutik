package com.Shop.GestBoutik.shelve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Shelve;
import com.Shop.GestBoutik.models.Store;
import com.Shop.GestBoutik.store.StoreService;

@Service
public class ShelveServiceImpl implements ShelveService {
	
	@Autowired
	private ShelveRepository shelveRepository;
	
	@Autowired
	private StoreService storeService;
	
	
	public boolean verifyIfShelveAlreadyExist(Shelve shelve) {
		
		boolean verification = true;

		List<Shelve> shelves = findAll();

		for (Shelve currentShelve : shelves) {

			if (shelve.getDesignation().equals(currentShelve.getDesignation())) {

				verification = false;
			}
		}
		return verification;
	}
	
	
	

	//	PPPPPPP		AAA		RRRRRR	  SSSSSSS	EEEEEEE
	//	PP   PP	   AA AA	RR	 RR	  SS		EE
	//	PP   PP	  AA   AA	RR	 RR	  SS		EE
	//	PPPPPPP	  AAAAAAA	RRRRRR	  SSSSSSS	EEEEEE
	//	PP		  AA   AA	RRRR	   	   SS	EE
	//	PP		  AA   AA	RR	RR		   SS	EE
	//	PP		  AA   AA	RR   RR	  SSSSSSS	EEEEEEE


	//	PARSE MODEL TO DTO
	/**
	 * parse a Shelve to a ShelveDto
	 * @param Shelve
	 * @return ShelveDto
	 */
	@Override
	public ShelveDto parseModelToDto(Shelve shelve) {

		ShelveDto shelveDto = new ShelveDto();

		shelveDto.setId(shelve.getId());
		shelveDto.setIdStore(shelve.getStore().getId());
		shelveDto.setDesignation(shelve.getDesignation());

		return shelveDto;
	}

	
	//	PARSE LIST MODEL TO DTO
	/**
	 * parse a list of Shelve to list of ShelveDto
	 * @Param List<Shelve>
	 * @return Collection<ShelveDto>
	 */
	@Override
	public Collection<ShelveDto> parseListModelToDto(Collection<Shelve> shelves) {

		Collection<ShelveDto> shelvesDto = new ArrayList<ShelveDto>();
		for (Shelve shelve : shelves) {
			shelvesDto.add(parseModelToDto(shelve));
		}

		return shelvesDto;
	}

	/**
	 * parse a ShelveDto to Shelve
	 * @param ShelveDto
	 * @return Shelve
	 */
	//	PARSE DTO TO MODEL
	@Override
	public Shelve parseDtoToModel(ShelveDto shelveDto) {

		Shelve shelve = new Shelve();

		shelve.setId(shelveDto.getId());
		shelve.setStore(storeService.findById(shelveDto.getIdStore()).get());
		shelve.setDesignation(shelveDto.getDesignation());

		return shelve;
	}
	

	//	DDDDD		BBBBBB
	//	DD  DD		BB   BB
	//	DD   DD		BB   BB
	//	DD   DD		BBBBBB
	//	DD   DD		BB   BB
	//	DD  DD		BB   BB
	//	DDDDD		BBBBBB

	@Override
	public Optional<Shelve> findById(Long id) {

		return shelveRepository.findById(id);
	}

	@Override
	public List<Shelve> findAll() {

		return shelveRepository.findAll();
	}



}
