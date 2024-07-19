package com.etixapp.models;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GenericGenerator(name = "native", strategy = "native")
	private long id;


	@Column(name = "text")
	//@Transient // if this is present when database is first created, this field will not be created in database
	// if it is added after the database is created, this field is not be persisted in database
	private String text;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// property in not accessible at read (not present in response)
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private boolean deleted;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// property in not accessible at read (not present in response)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	// property in not accessible at read (not present in response)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified")
	private Date modified;
}
