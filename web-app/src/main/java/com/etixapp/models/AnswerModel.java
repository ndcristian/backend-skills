package com.etixapp.models;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// BiDirectional ManyToOne - OneToMany

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerModel {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) if only this is present then a new table is created is database with the id sequence
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "text")
	//@Transient // if this is present when database is first created, this field will not be created in database
	// if it is added after the database is created, this field is not be persisted in database , NULL is added
	private String text;

	@JsonBackReference // avoid stackoverflow call error but the question is not added in the request
	// also save throws error without it
	//@JsonIgnore // it skips this field from serialization also in get/find and post.save method
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private QuestionModel question;

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
