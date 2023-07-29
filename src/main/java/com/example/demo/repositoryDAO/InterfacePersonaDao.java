package com.example.demo.repositoryDAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modelEntity.Persona;

//public interface InterfacePersonaDao extends CrudRepository<Persona, Long>{
public interface InterfacePersonaDao extends JpaRepository<Persona, Long>{
	
	@Query(value = "SELECT * FROM PERSONA WHERE id_persona = ?1", nativeQuery = true)
	Persona queryPersonalizada(Long idPersona);
	
	@Query(value = "SELECT * FROM PERSONA WHERE nombre = ?1 AND apellido = ?2", nativeQuery = true)
	Optional<Persona> validateUserAndPass(String nombre, String apellido);
	
}
