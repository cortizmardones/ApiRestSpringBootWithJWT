package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelEntity.Persona;
import com.example.demo.repositoryDAO.InterfacePersonaDao;

@Service
public class PersonaServiceImpl implements InterfacePersonaService {

	@Autowired
	private InterfacePersonaDao interfacePersonaDao;
	
	@Override
	@Transactional
	public int createPerson(Persona persona) {
		if(persona.getIdPersona() == null) {
			interfacePersonaDao.save(persona);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> readPerson(Long id) {
		Optional<Persona> optPersona = interfacePersonaDao.findById(id);
		return optPersona;
	}

	@Override
	@Transactional
	public int updatePerson(Persona persona) {
		if(interfacePersonaDao.existsById(persona.getIdPersona())) {
			interfacePersonaDao.save(persona);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int deletePerson(Long id) {
		if(interfacePersonaDao.existsById(id)) {
			interfacePersonaDao.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> readAllPerson() {
		return interfacePersonaDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Persona queryPersonalizada(Long id) {
		return interfacePersonaDao.queryPersonalizada(id);
	}
	
	@Transactional(readOnly = true)
	public Optional<Persona> validateUserAndPass(String nombre, String apellido) {
		return interfacePersonaDao.validateUserAndPass(nombre, apellido);
	}
	
}
