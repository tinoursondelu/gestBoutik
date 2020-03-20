package com.Shop.GestBoutik.helper.enumeration;

public enum SizeEnum {
	
	XS (1L, ""),
	S (2L, ""),
	M (3L, ""),
	L (4L, ""),
	XL (5L, ""),
	XXL (6L, "");
	
	private Long id = 0L;
	private String label;
	
//	CONSTRUCTOR
	SizeEnum(Long id, String label) {
		
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
