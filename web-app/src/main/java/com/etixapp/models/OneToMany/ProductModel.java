package com.etixapp.models.OneToMany;


import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** In this case a link table wil be created to keep the relation between entities */

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) if only this is present without other options then a new table is created. A table with the id sequence
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "name")
	//@Transient // if this is present when database is first created, this field will not be created in database
	// if it is added after the database is created, this field is not be persisted in database , NULL is added
	private String name;

	@OneToMany
	private List<ColorModel> colors;
}
