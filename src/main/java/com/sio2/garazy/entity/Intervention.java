package com.sio2.garazy.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sio2.garazy.enumeration.StatutIntervention;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Intervention {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, name="date_debut")
	private LocalDate dateDebut;
	@Column(nullable=false, name="date_fin")
	private LocalDate dateFin;
	@Column(nullable=false, length=1000)
	private String description;
	@Enumerated(EnumType.STRING)
	private StatutIntervention statut;
	@Column(nullable=false, name="cout_main_oeuvre")
	private BigDecimal coutMainOeuvre;
	@ManyToMany(mappedBy="interventions")
	private List<Mecanicien> intervenants = new ArrayList<Mecanicien>();
	@ManyToOne
	@JoinColumn(name="vehicule_id", nullable=false)
	private Vehicule vehicule;
	@OneToMany(mappedBy="intervention")
	private List<LigneIntervention> lignesIntervention = new ArrayList<LigneIntervention>();
	@OneToOne(optional=false)
	@JoinColumn(name="facture_id", nullable=false)
	private Facture facture;
	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Intervention(LocalDate dateDebut, LocalDate dateFin, String description, StatutIntervention statut,
			BigDecimal coutMainOeuvre, List<Mecanicien> intervenants, Vehicule vehicule,
			List<LigneIntervention> lignesIntervention, Facture facture) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.statut = statut;
		this.coutMainOeuvre = coutMainOeuvre;
		this.intervenants = intervenants;
		this.vehicule = vehicule;
		this.lignesIntervention = lignesIntervention;
		this.facture = facture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StatutIntervention getStatut() {
		return statut;
	}
	public void setStatut(StatutIntervention statut) {
		this.statut = statut;
	}
	public BigDecimal getCoutMainOeuvre() {
		return coutMainOeuvre;
	}
	public void setCoutMainOeuvre(BigDecimal coutMainOeuvre) {
		this.coutMainOeuvre = coutMainOeuvre;
	}
	public List<Mecanicien> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(List<Mecanicien> intervenants) {
		this.intervenants = intervenants;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public List<LigneIntervention> getLignesIntervention() {
		return lignesIntervention;
	}
	public void setLignesIntervention(List<LigneIntervention> lignesIntervention) {
		this.lignesIntervention = lignesIntervention;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
}
