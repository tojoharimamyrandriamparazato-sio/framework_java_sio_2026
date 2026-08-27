package com.sio2.garazy.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sio2.garazy.enumeration.StatutFacture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, length=25, unique=true)
	private String numero;
	@Column(nullable=false, name="date_emission")
	private LocalDate dateEmission;
	@Column(nullable=false, name="montant_total")
	private BigDecimal montantTotal;
	@Enumerated(EnumType.STRING)
	private StatutFacture statut;
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	private Client client;
	@OneToOne(mappedBy="facture")
	private Intervention intervention;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String numero, LocalDate dateEmission, BigDecimal montantTotal, StatutFacture statut, Client client,
			Intervention intervention) {
		super();
		this.numero = numero;
		this.dateEmission = dateEmission;
		this.montantTotal = montantTotal;
		this.statut = statut;
		this.client = client;
		this.intervention = intervention;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDate getDateEmission() {
		return dateEmission;
	}
	public void setDateEmission(LocalDate dateEmission) {
		this.dateEmission = dateEmission;
	}
	public BigDecimal getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(BigDecimal montantTotal) {
		this.montantTotal = montantTotal;
	}
	public StatutFacture getStatut() {
		return statut;
	}
	public void setStatut(StatutFacture statut) {
		this.statut = statut;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
}
