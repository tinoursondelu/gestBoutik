package com.Shop.GestBoutik.helper.enumeration;

/**
 * Entity class for handle Store type
 * @author Guiot Olivier
 * @version 202003
 *
 */
public enum ColorEnum {
	
	White (1L, ""),
	Red (2L, ""),
	Blue (3L, ""),
	Green (4L, ""),
	Black (5L, "");
	
	private Long id = 0L;
	private String label;
	
//	CONSTRUCTOR
	ColorEnum(Long id, String label) {
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
