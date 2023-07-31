package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO_REPOSITORY.IRazaDAO;
import com.example.demo.MODEL_ENTITY.Raza;

@Service
public class RazaService implements IRazaService {

	@Autowired
	private IRazaDAO iRazaDAO;
	
	@Override
	@Transactional
	public int createRaza(Raza raza) {
		if(raza.getId() == null) {
			iRazaDAO.save(raza);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Raza> readRaza(Long id) {
		Optional<Raza> optRaza = iRazaDAO.findById(id);
		return optRaza;
	}

	@Override
	@Transactional
	public int updateRaza(Raza raza) {
		if(iRazaDAO.existsById(raza.getId())) {
			iRazaDAO.save(raza);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int deleteRaza(Long id) {
		if(iRazaDAO.existsById(id)) {
			iRazaDAO.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Raza> readAllRaza() {
		return iRazaDAO.findAll();
	}
	
}
