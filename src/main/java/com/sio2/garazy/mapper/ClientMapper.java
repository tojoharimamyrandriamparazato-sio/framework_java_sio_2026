package com.sio2.garazy.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sio2.garazy.dto.ClientDTO;
import com.sio2.garazy.entity.Client;
import com.sio2.garazy.entity.Facture;
import com.sio2.garazy.entity.Vehicule;

public class ClientMapper {
	public static ClientDTO toDto(Client client) {
		ClientDTO dto = new ClientDTO(
				client.getId(),
				client.getNom(),
				client.getPrenom(),
				client.getEmail(),
				client.getTelephone());
		return dto;
	}
	public static Client toEntity(ClientDTO dto) {
		Client entity = new Client(
				dto.getNom(),
				dto.getPrenom(),
				dto.getEmail(),
				dto.getTelephone(),
				new ArrayList<Vehicule>(),
				new ArrayList<Facture>());
		return entity;
	}
}
