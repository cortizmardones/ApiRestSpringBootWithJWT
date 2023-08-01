package com.example.demo.MODEL_ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "raza")
public class Raza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRaza;
	
	private String nombre;

	public Raza() {
	}
	
	public Raza(Long idRaza, String nombre) {
		this.idRaza = idRaza;
		this.nombre = nombre;
	}

}
