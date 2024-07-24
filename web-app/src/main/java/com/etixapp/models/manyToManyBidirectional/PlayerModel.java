package com.etixapp.models.manyToManyBidirectional;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private long id;

	@Column(name = "name")
	private String name;

	@JsonManagedReference
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "players_rooms",
			joinColumns = { @JoinColumn(name = "player_id") },
			inverseJoinColumns = { @JoinColumn(name = "room_id") }
	)
	private List<RoomModel> rooms;
}
