package com.sio2.garazy.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.sio2.garazy.entity.Client;
import com.sio2.garazy.entity.Facture;
import com.sio2.garazy.entity.Vehicule;

@DataJpaTest
class ClientRepositoryTest {
	@Autowired
	ClientRepository clientRepository;
	@Test
	void shouldCreateClient() {
		Client hoAmpidirina = new Client("Benja", "Kely", "kely@gmail.com", "0321124874", null, null);
		Client tafiditra = clientRepository.save(hoAmpidirina);
		Assertions.assertNotNull(tafiditra);
		Assertions.assertEquals(tafiditra.getNom(), hoAmpidirina.getNom());
	}
	@Test
	void shouldListAllClients() {
		Client c1 = new Client("Benja", "Kely", "kely@gmail.com", "0321124874", null, null);
		Client c2 = new Client("Ranja", "Ly", "ly@gmail.com", "0321124875", null, null);
		clientRepository.save(c1);
		clientRepository.save(c2);
		List<Client> liste = clientRepository.findAll();
		Assertions.assertEquals(2, liste.size());
	}
	@Test
	void shouldUpdateClient() {
		Client c1 = new Client("Benja", "Kely", "kely@gmail.com", "0321124874", null, null);
		Client c2 = clientRepository.save(c1);
		c2.setNom("Rakotobe");
		clientRepository.save(c2);
		List<Client> liste = clientRepository.findAll();
		Assertions.assertEquals(1, liste.size());
	}
}
