package com.sio2.garazy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sio2.garazy.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
