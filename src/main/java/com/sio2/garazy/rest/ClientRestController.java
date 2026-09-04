package com.sio2.garazy.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sio2.garazy.dto.ClientDTO;
import com.sio2.garazy.entity.Client;
import com.sio2.garazy.mapper.ClientMapper;
import com.sio2.garazy.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
	private ClientService clientService;
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	@GetMapping
	public List<ClientDTO> lireTout() {
		return this.clientService.trouverTous();
	}
	
	@GetMapping("/recherche")
	public Page<ClientDTO> rechercher(
			@RequestParam(defaultValue="") String nom,
			@RequestParam(defaultValue="") String prenom,
			@RequestParam(defaultValue="") String email,
			@RequestParam(defaultValue="") String telephone,
			@RequestParam(defaultValue="0") int numpage,
			@RequestParam(defaultValue="nom") String colonnetri,
			@RequestParam(defaultValue="asc") String senstri) {
		Direction direction = senstri.equals("asc") ? 
				Direction.ASC : Direction.DESC;
		Pageable pageable = PageRequest.of(
				numpage,
				10,
				Sort.by(direction, colonnetri));
		return this.clientService.rechercher(
				nom,
				prenom,
				email,
				telephone,
				pageable);
	}
	@GetMapping("/requetemixte")
	public Map<String, Object> compterParNom() {
		return this.clientService.requeteMixte();
	}
	
	@PostMapping
	public ResponseEntity<?> creerClient(@Valid @RequestBody
			ClientDTO dto) {
		ClientDTO created = this.clientService.ajouter(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> lireClient(@PathVariable Long id) {
		ClientDTO found = this.clientService.recuperer(id);
		return ResponseEntity.status(HttpStatus.OK).body(found);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> modifierClient(@PathVariable Long id,
			@Valid @RequestBody ClientDTO dto) {
		ClientDTO modified = this.clientService.modifier(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(modified);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> supprimerClient(@PathVariable Long id) {
		this.clientService.supprimer(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
