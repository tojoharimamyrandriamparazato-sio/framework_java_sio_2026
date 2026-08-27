package com.sio2.garazy.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneIntervention {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private int quantite;
	@Column(nullable=false, name="prix_unitaire")
	private BigDecimal prixUnitaire;
	@ManyToOne
	@JoinColumn(name="piece_detachee_id", nullable=false)
	private PieceDetachee pieceDetachee;
	@ManyToOne
	@JoinColumn(name="intervention_id", nullable=false)
	private Intervention intervention;
	public LigneIntervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneIntervention(int quantite, BigDecimal prixUnitaire, PieceDetachee pieceDetachee,
			Intervention intervention) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.pieceDetachee = pieceDetachee;
		this.intervention = intervention;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public PieceDetachee getPieceDetachee() {
		return pieceDetachee;
	}
	public void setPieceDetachee(PieceDetachee pieceDetachee) {
		this.pieceDetachee = pieceDetachee;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
}
