package com.example.demo.DAO_REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.MODEL_ENTITY.Persona;

//public interface InterfacePersonaDao extends CrudRepository<Persona, Long>{
public interface IPersonaDAO extends JpaRepository<Persona, Long>{
		
	@Query(value = "SELECT * FROM PERSONA WHERE nombre = ?1 AND apellido = ?2", nativeQuery = true)
	Optional<Persona> validateUserAndPass(String nombre, String apellido);
	
}
