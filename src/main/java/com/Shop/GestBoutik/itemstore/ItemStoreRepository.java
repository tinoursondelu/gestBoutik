package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.ItemStore;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStoreRepository extends JpaRepository<ItemStore, Long> {

	Optional<ItemStore> findByDesignation(String designation);

}
