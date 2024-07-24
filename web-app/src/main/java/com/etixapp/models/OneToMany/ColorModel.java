package com.etixapp.models.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "color")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorModel {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) if only this is present then a new table is created is database with the id sequence
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "text")
	//@Transient // if this is present when database is first created, this field will not be created in database
	// if it is added after the database is created, this field is not be persisted in database , NULL is added
	private String text;

}
