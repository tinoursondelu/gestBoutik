package com.Shop.GestBoutik.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shop.GestBoutik.models.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	
	Optional<Color> findById(Long id);

	Optional<Color> findByLabel(String label);

}
