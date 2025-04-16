package com.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class PlayerBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int age;
	
	
	@ManyToOne
	@JoinColumn(name="team_id")
	@JsonManagedReference
	private TeamBean team;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public TeamBean getTeam() {
		return team;
	}


	public void setTeam(TeamBean team) {
		this.team = team;
	}
	
	
	
	
	
}
