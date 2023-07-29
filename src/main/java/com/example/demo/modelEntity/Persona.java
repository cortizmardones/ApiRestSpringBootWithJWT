package com.example.demo.modelEntity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	public Persona() {
		
	}

	public Persona(Long idPersona, String nombre, String apellido, String email, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	
	
	
	
}
