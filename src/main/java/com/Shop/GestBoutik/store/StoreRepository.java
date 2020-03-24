package com.Shop.GestBoutik.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.GestBoutik.models.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	

}
