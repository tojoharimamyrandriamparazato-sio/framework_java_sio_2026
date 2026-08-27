package com.sio2.garazy.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length=10, unique=true)
	private String immatricule;
	@Column(nullable=false, length=50)
	private String marque;
	@Column(nullable=false, length=50)
	private String modele;
	@Column(nullable=false, length=4)
	private int annee;
	@Column(nullable=false)
	private int kilometrage;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client proprietaire;
	@OneToMany(mappedBy="vehicule")
	private List<Intervention> interventions = new ArrayList<Intervention>();
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicule(String immatricule, String marque, String modele, int annee, int kilometrage, Client proprietaire,
			List<Intervention> interventions) {
		super();
		this.immatricule = immatricule;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.kilometrage = kilometrage;
		this.proprietaire = proprietaire;
		this.interventions = interventions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}
	public Client getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
}
