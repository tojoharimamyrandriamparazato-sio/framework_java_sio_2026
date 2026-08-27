package com.sio2.garazy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoucouController {

	@GetMapping("/voalohany")
	public String coucou() {
		return "Coucou les gens !";
	}
}
