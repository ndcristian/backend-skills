package com.etixapp.models.planning;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "branch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// *#I* - generate a dedicated table in DB with the id index called branch_seq
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "details")
	private String details;

	@OneToOne
	private ScopeModel scope;

	@Column(name = "other")
	private String other;

	@OneToMany
	private List<ActionModel> activities;

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

	// this solution leads to a large number of appointments which will populate every get request of branches
	//	@OneToMany(cascade=CascadeType.ALL)
	//	private List<AppointmentModel> appointments;
}
