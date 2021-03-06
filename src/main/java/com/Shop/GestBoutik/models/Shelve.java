package com.Shop.GestBoutik.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@Table(name = "shelves")
public class Shelve extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Length(min = 3, max = 30)
	@Column(nullable = false, unique = true)
	private String designation;

	@ManyToOne
	private Store store;

	@OneToMany(mappedBy ="shelve" )
	private Collection<ItemStore> itemsStore;
	
	



}
