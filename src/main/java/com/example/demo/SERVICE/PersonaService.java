package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO_REPOSITORY.IPersonaDAO;
import com.example.demo.MODEL_ENTITY.Persona;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaDAO iPersonaDAO;
	
	@Override
	@Transactional
	public int createPerson(Persona persona) {
		if(persona.getIdPersona() == null) {
			iPersonaDAO.save(persona);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> readPerson(Long id) {
		Optional<Persona> optPersona = iPersonaDAO.findById(id);
		return optPersona;
	}

	@Override
	@Transactional
	public int updatePerson(Persona persona) {
		if(iPersonaDAO.existsById(persona.getIdPersona())) {
			iPersonaDAO.save(persona);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int deletePerson(Long id) {
		if(iPersonaDAO.existsById(id)) {
			iPersonaDAO.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> readAllPerson() {
		return iPersonaDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> validateUserAndPass(String nombre, String apellido) {
		return iPersonaDAO.validateUserAndPass(nombre, apellido);
	}
	
}
