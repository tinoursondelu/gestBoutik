package com.Shop.GestBoutik.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.helper.enumeration.BrandEnum;
import com.Shop.GestBoutik.helper.enumeration.ColorEnum;
import com.Shop.GestBoutik.helper.enumeration.SizeEnum;
import com.Shop.GestBoutik.models.Brand;
import com.Shop.GestBoutik.services.BrandServiceImpl;
import com.Shop.GestBoutik.services.ColorServiceImpl;
import com.Shop.GestBoutik.services.SizeServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RestController
@RequestMapping("/test")
public class test {
	
	@Autowired
	private BrandServiceImpl brandService;
	
	@Autowired
	private ColorServiceImpl ColorService;
	
	@Autowired
	private SizeServiceImpl sizeService;
	
	

	@GetMapping("/test") /*ok*/
	@ResponseBody
	public void test() {
		
		Optional<Brand> brand = brandService.findById(BrandEnum.Nike.getId());
		
		if (brand.isPresent()) {
			
			if (brand.get().getId() == BrandEnum.Nike.getId()) {
				
				System.out.println("la marque est " + brand.get().getLabel());
				
			}
		}
		

		System.out.println("marque id = " + BrandEnum.Nike.getId());
		System.out.println("taille id = " + SizeEnum.L.getId());
		System.out.println("couleur id = " + ColorEnum.Black.getId());
		log.trace("plop");
	}

}
