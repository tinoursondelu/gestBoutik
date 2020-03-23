package com.Shop.GestBoutik.helper.enumeration;

/**
 * Entity class for handle Store type
 * @author Guiot Olivier
 * @version 202003
 *
 */
public enum BrandEnum {
	
	Nike (1L, ""),
	Pumas (2L, "");
	
	private Long id = 0L;
	private String label;
	
//	CONSTRUCTOR
	BrandEnum(Long id, String label) {
		
		this.id = id;
		this.label = label;
	}
	
//	GETTERS
	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
	

}
