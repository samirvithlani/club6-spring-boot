package com.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class TeamBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String teamName;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<PlayerBean> players = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<PlayerBean> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerBean> players) {
		this.players = players;
	}

}
