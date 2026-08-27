package com.sio2.garazy.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PieceDetachee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=25, unique=true, nullable=false)
	private String reference;
	@Column(nullable=false, length=50)
	private String nom;
	@Column(nullable=false, name="prix_unitaire")
	private BigDecimal prixUnitaire;
	@Column(nullable=false)
	private int quantiteStock;
	@OneToMany(mappedBy="pieceDetachee")
	private List<LigneIntervention> lignesIntervention = new ArrayList<LigneIntervention>();
	public PieceDetachee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PieceDetachee(String reference, String nom, BigDecimal prixUnitaire, int quantiteStock,
			List<LigneIntervention> lignesIntervention) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.quantiteStock = quantiteStock;
		this.lignesIntervention = lignesIntervention;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public List<LigneIntervention> getLignesIntervention() {
		return lignesIntervention;
	}
	public void setLignesIntervention(List<LigneIntervention> lignesIntervention) {
		this.lignesIntervention = lignesIntervention;
	}
	
}
