package com.etixapp.models.oneToManyBidirectional;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// BiDirectional ManyToOne - OneToMany

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "answer")
	private String answer;

	//@JsonIgnore // it skips this field from serialization/deserialization  also in get/find and post.save method.
	// It could be used in a normal class , and it is not related to database persistence
	@JsonManagedReference // avoid stackoverflow call error and add options to the request
	// also save throws error without it
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	// without mapBy and JoinColumn on the child entity (AnswerModel) , another table is created to link this two entities
	// without  orphanRemoval = true when we try to update the question by removing one of its answers , the answer is not deleted from answer table
	// CascadeType.ALL will delete the child entity when parent is deleted but if we update the parent like above, the child entity is not deleted and
	// for this reason we have to use here orphanRemoval = true
	@Column(name = "options")
	private List<AnswerModel> options;

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
