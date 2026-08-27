package com.sio2.garazy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientDTO {
	private Long id;
	@NotBlank(message="Le nom ne peut pas être vide")
	@Size(min=2, max=25, message="Le nom doit contenir entre 2 à 25 caractères")
	private String nom;
	@NotBlank(message="Le prénom ne peut pas être vide")
	@Size(min=2, max=25, message="Le prénom doit contenir entre 2 à 25 caractères")
	private String prenom;
	@NotBlank(message="L'email ne peut pas être vide")
	@Email(message="Format de l'email invalide")
	private String email;
	@Pattern(regexp="^(0|\\+261)(32|33|34|37|38)\\d{7}$",
			message="Numéro de téléphone malgache invalide")
	private String telephone;
	public ClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientDTO(Long id, String nom, String prenom, String email, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
