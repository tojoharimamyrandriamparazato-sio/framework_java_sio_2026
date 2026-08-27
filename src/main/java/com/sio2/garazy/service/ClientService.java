package com.sio2.garazy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sio2.garazy.dto.ClientDTO;
import com.sio2.garazy.entity.Client;
import com.sio2.garazy.exception.ResourceNotFoundException;
import com.sio2.garazy.mapper.ClientMapper;
import com.sio2.garazy.repository.ClientRepository;

@Service
public class ClientService {
	private ClientRepository clientRepository;
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	public List<ClientDTO> trouverTous() {
		List<Client> clients = this.clientRepository.findAll();
		List<ClientDTO> dtos = new ArrayList<ClientDTO>();
		for(Client c : clients) {
			dtos.add(new ClientDTO(c.getId(), c.getNom(), c.getPrenom(), c.getEmail(), c.getTelephone()));
		}
		return dtos;
	}
	public ClientDTO ajouter(ClientDTO dto) {
		return ClientMapper.toDto(clientRepository.save(ClientMapper.toEntity(dto)));
	}
	public ClientDTO recuperer(Long id) {
		Client client = this.clientRepository.findById(id)
			.orElseThrow(() -> 
			new ResourceNotFoundException("Client", " avec id inexistant : "
					+ id));
		return ClientMapper.toDto(client);
	}
	public ClientDTO modifier(Long id, ClientDTO dto) {
		Client existing = ClientMapper.toEntity(this.recuperer(id));
		existing.setId(id);
		existing.setNom(dto.getNom());
		existing.setPrenom(dto.getPrenom());
		existing.setEmail(dto.getEmail());
		existing.setTelephone(dto.getTelephone());
		return ClientMapper.toDto(this.clientRepository.save(existing));
	}
	public void supprimer(Long id) {
		this.recuperer(id);
		this.clientRepository.deleteById(id);
	}
}
