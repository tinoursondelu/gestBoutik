package com.Shop.GestBoutik.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.GestBoutik.models.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
	
	Optional<Size> findById(Long id);

	Optional<Size> findByLabel(String label);

}
