package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import com.example.demo.MODEL_ENTITY.Persona;

public interface IPersonaService {

	// CRUD
	public int createPerson(Persona persona);
	public Optional<Persona> readPerson(Long id);
	public int updatePerson(Persona persona);
	public int deletePerson(Long id);
	
	
	// OTHERS
	public List<Persona> readAllPerson();
		

}
