package com.sio2.garazy.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Mecanicien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length=50)
	private String nom;
	@Column(nullable=false, length=50)
	private String prenom;
	@Column(nullable=false, length=50)
	private String specialite;
	@Column(nullable=false, length=15)
	private String telephone;
	@ManyToMany
	@JoinTable(
		name="intervention_mecanicien",
		joinColumns=@JoinColumn(name="mecanicien_id"),
		inverseJoinColumns=@JoinColumn(name="intervention_id")
	)
	private List<Intervention> interventions = new ArrayList<Intervention>();
	public Mecanicien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mecanicien(String nom, String prenom, String specialite, String telephone,
			List<Intervention> interventions) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.telephone = telephone;
		this.interventions = interventions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
}
