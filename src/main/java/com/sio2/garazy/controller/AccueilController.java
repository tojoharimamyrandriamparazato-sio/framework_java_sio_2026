package com.sio2.garazy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
	@GetMapping("/")
	public String accueil() {
		return "accueil";
	}
}
