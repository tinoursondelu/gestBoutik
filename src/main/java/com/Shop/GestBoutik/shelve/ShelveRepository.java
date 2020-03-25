package com.Shop.GestBoutik.shelve;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.GestBoutik.models.Shelve;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve, Long> {

	public List<Shelve> findAllByStoreId(Long storeId);
	
	Optional<Shelve> findByDesignation(String designation);

}
