package com.Shop.GestBoutik.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Entity class for handle Store type
 * @author Guiot Olivier
 * @version 202003
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Valid
@Entity
@Table(name = "sizes")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Length(min = 3, max = 30)
	@Column(nullable = false, unique = true)
	private String label;

	@JsonIgnore
	@OneToMany(mappedBy = "size")
	private List<ItemStore> itemStores;

}
