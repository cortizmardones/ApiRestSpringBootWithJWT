package com.example.demo.SERVICE;

import java.util.List;
import java.util.Optional;

import com.example.demo.MODEL_ENTITY.Raza;

public interface IRazaService {
	
	// CRUD
	public int createRaza(Raza raza);
	public Optional<Raza> readRaza(Long id);
	public int updateRaza(Raza raza);
	public int deleteRaza(Long id);
	
	
	// OTHERS
	public List<Raza> readAllRaza();

}
