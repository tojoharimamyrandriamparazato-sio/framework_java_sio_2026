package com.sio2.garazy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sio2.garazy.entity.Client;
import com.sio2.garazy.mapper.ClientMapper;
import com.sio2.garazy.service.ClientService;

@Controller
public class ClientController { 
	private final ClientService clientService; 
	public ClientController(ClientService clientService) { 
		this.clientService = clientService; 
	} 
	@GetMapping("/clients") 
	public String liste(Model model) { 
		model.addAttribute("clients", clientService.trouverTous()); 
		return "clients/liste"; 
	} 
	@GetMapping("/clients/nouveau") 
	public String formulaire(Model model) { 
		model.addAttribute("client", new Client()); 
		return "clients/formulaire"; 
	} 
	@PostMapping("/clients") 
	public String ajouter(Client client) { 
		this.clientService.ajouter(ClientMapper.toDto(client));
		return "redirect:/clients";
	} 
} 
