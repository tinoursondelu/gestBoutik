package com.Shop.GestBoutik.helper.controller;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shop.GestBoutik.helper.enumeration.BrandEnum;
import com.Shop.GestBoutik.helper.enumeration.ColorEnum;
import com.Shop.GestBoutik.helper.enumeration.SizeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@RestController
@RequestMapping("/test")
public class test {
	
	@GetMapping("/test") /*ok*/
	@ResponseBody
	public void test() {
		
		System.out.println("marque id = " + BrandEnum.Nike.getId());
System.out.println("taille id = " + SizeEnum.L.getId());
System.out.println("couleur id = " + ColorEnum.Black.getId());
	}

}
