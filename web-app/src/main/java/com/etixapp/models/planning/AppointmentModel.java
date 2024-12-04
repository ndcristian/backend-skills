package com.etixapp.models.planning;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	//*#I* - in this case   appointment_seq for id will not be generated
	// see the branch model
	private long id;

	@Column(name = "name")
	private String name;

	@OneToOne
	private BranchModel branch;

	@OneToMany
	private List<TodoModel> todo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_start")
	private Date dateStart;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_end")
	private Date dateEnd;

	@Column(name = "index_from")
	private int indexFrom;

	@Column(name = "index_to")
	private int indexTo;

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
