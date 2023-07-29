package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelEntity.Persona;

public interface InterfacePersonaService {

	// CRUD
	public int createPerson(Persona persona);
	public Optional<Persona> readPerson(Long id);
	public int updatePerson(Persona persona);
	public int deletePerson(Long id);
	
	
	// OTHERS
	public List<Persona> readAllPerson();
		

}
