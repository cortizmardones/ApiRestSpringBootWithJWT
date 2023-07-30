package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import com.example.demo.MODEL_ENTITY.Mascota;

public interface IMascotaService {

	// CRUD
	public int createMascota(Mascota mascota);
	public Optional<Mascota> readMascota(Long id);
	public int updateMascota(Mascota mascota);
	public int deleteMascota(Long id);
	
	
	// OTHERS
	public List<Mascota> readAllMascota();
		

}
