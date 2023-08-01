package com.example.demo.MODEL_ENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMascota;
	
	private String nombre;
	
	@ManyToOne // Una raza puede tener varias mascotas
	@JoinColumn(name = "idraza") // El name indica el campo que aparecera en la tabla Mascota para referenciar la FK)
	private Raza raza;
	
	@ManyToOne // Una persona puede tener varias mascotas
	@JoinColumn(name = "idpersona") // El name indica el campo que aparecera en la tabla Mascota para referenciar la FK)
	private Persona persona;
	
	public Mascota() {
	}

	public Mascota(Long idMascota, String nombre, Raza raza) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
	}



}
