package com.Shop.GestBoutik.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Shop.GestBoutik.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	Optional<Item> findById(Long id);

	Optional<Item> findByDesignation(String designation);
	
	List<Item> findAll();
}
