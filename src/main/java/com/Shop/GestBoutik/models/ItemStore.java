package com.Shop.GestBoutik.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.Shop.GestBoutik.helper.enumeration.BrandEnum;
import com.Shop.GestBoutik.helper.enumeration.ColorEnum;
import com.Shop.GestBoutik.helper.enumeration.SizeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity class for handle Shelve type
 * @author Guiot Olivier
 * @version 202003
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Valid
@Entity
@Table(name = "items_store")
public class ItemStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Length(min = 3, max = 30)
	@Column(nullable = false, unique = true)
	private String designation;
	
	private ColorEnum color;
	
	private SizeEnum size;
	
	private BrandEnum brand;

	@ManyToMany
	private Collection<Store> stores;
	
	@ManyToMany(mappedBy = "itemsStore")
	private Collection<Shelve> shelves;
	
	@ManyToOne
	private Item item;
	
	


}
