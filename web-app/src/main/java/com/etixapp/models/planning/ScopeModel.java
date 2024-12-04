package com.etixapp.models.planning;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scope")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "details")
	private String details;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private boolean deleted;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created")
	private Date created;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified")
	private Date modified;
}
