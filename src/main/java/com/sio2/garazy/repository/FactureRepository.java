package com.sio2.garazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sio2.garazy.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
