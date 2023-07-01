package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("persona")
@Slf4j
public class RestControler {

	@Autowired
	private PersonaServiceImpl personaServiceImpl;
	
	@Autowired
	private JWTController jwtController;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Persona persona , @RequestHeader String token , @RequestHeader String user) {
		if(jwtController.validateToken(token, user)) {
			try {
				int result = personaServiceImpl.createPerson(persona);
				if (result == 1) {
					return ResponseEntity.ok("Persona: " + persona.getNombre() + " insertada");
				}
			} catch (Exception e) {
				log.error("Error", e);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Persona> read(@PathVariable("id") Long id , @RequestHeader String token, @RequestHeader String user) {
		if(jwtController.validateToken(token, user)) {
			try {
				Optional<Persona> optPersona = personaServiceImpl.readPerson(id);
				if (optPersona.isPresent()) {
					Persona persona = optPersona.get();
					return ResponseEntity.ok(persona);
				}
			} catch (Exception e) {
				log.error("Error", e);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Persona persona, @RequestHeader String token, @RequestHeader String user) {
		if(jwtController.validateToken(token, user)) {
			try {
				int result = personaServiceImpl.updatePerson(persona);
				if (result == 1) {
					return ResponseEntity.ok("Persona ID: " + persona.getIdPersona() + " actualizada");
				}
			} catch (Exception e) {
				log.error("Error", e);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id , @RequestHeader String token, @RequestHeader String user) {
		if(jwtController.validateToken(token, user)) {
			try {
				int result = personaServiceImpl.deletePerson(id);
				if (result == 1) {
					return ResponseEntity.ok("Persona ID: " + id + " eliminada");
				}
			} catch (Exception e) {
				log.error("Error", e);
			}
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> listar(@RequestHeader String token, @RequestHeader String user) {
		if(jwtController.validateToken(token, user)) {
			List<Persona> personList = null;
			try {
				personList = personaServiceImpl.readAllPerson();
				if (personList != null && personList.size() > 0) {
					return ResponseEntity.ok(personList);
				}
			} catch (Exception e) {
				log.error("Error", e);
			}
		}
		return ResponseEntity.noContent().build();
	}

	// OBJETO JAVA A JSON
	// Gson gson = new Gson();
	// String json = gson.toJson(personList);

	// JSON A OBJETO JAVA
	// Gson gson = new Gson();
	// Persona[] footballPlayers = gson.fromJson(jsonAll, FootballPlayer[].class);
}
