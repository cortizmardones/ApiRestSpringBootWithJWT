package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DAO_REPOSITORY.IMascotaDAO;
import com.example.demo.MODEL_ENTITY.Mascota;

@Service
public class MascotaService implements IMascotaService {

	@Autowired
	private IMascotaDAO iMascotaDAO;
	
	@Override
	@Transactional
	public int createMascota(Mascota mascota) {
		if(mascota.getId() == null) {
			iMascotaDAO.save(mascota);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mascota> readMascota(Long id) {
		Optional<Mascota> optMascota = iMascotaDAO.findById(id);
		return optMascota;
	}

	@Override
	@Transactional
	public int updateMascota(Mascota mascota) {
		if(iMascotaDAO.existsById(mascota.getId())) {
			iMascotaDAO.save(mascota);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional
	public int deleteMascota(Long id) {
		if(iMascotaDAO.existsById(id)) {
			iMascotaDAO.deleteById(id);
			return 1;
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mascota> readAllMascota() {
		return iMascotaDAO.findAll();
	}
	
	
}
