package com.sio2.garazy.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sio2.garazy.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("""
			SELECT c
			FROM Client c
			WHERE
				c.nom LIKE :nom AND
				c.prenom LIKE :prenom AND
				c.email LIKE :email AND
				c.telephone LIKE :telephone
				""")
		Page<Client> filtrer(
			@Param("nom") String nom,
			@Param("prenom") String prenom,
			@Param("email") String email,
			@Param("telephone") String telephone,
			Pageable pageable);
	
	@Query("""
			SELECT c.nom, COUNT(c)
			FROM Client c
			GROUP BY c.nom""")
	List<Object[]> compterParNom();
	
	@Query("""
			SELECT MIN(c.nom)
			FROM Client c
			""")
	String nomMinAlphabetique();
	
	@Query("""
			SELECT MAX(c.nom)
			FROM Client c
			""")
	String nomMaxAlphabetique();
	
	/*@Query("""
		SELECT c
		FROM Client c
		WHERE
			c.nom LIKE :nom AND
			c.prenom LIKE :prenom AND
			c.email LIKE :email AND
			c.telephone LIKE :telephone
			""")
	List<Client> filtrer(
		@Param("nom") String nom,
		@Param("prenom") String prenom,
		@Param("email") String email,
		@Param("telephone") String telephone);*/
	
	/*List<Client> findByNomContainingAndPrenomContainingAndEmailContainingAndTelephoneContaining(
			String nom,
			String prenom,
			String email,
			String telephone);*/
}
