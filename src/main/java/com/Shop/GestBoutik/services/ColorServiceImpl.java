package com.Shop.GestBoutik.services;

import java.util.Optional;

import com.Shop.GestBoutik.models.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shop.GestBoutik.models.Color;
import com.Shop.GestBoutik.repository.ColorRepository;

@Service
public class ColorServiceImpl implements CharacteristicService {
	
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public Optional<Color> findById(Long id) {
		
		return colorRepository.findById(id);
	}

	@Override
	public Optional<Color> findByLabel(String label) {
		
		return colorRepository.findByLabel(label);
	}

}
