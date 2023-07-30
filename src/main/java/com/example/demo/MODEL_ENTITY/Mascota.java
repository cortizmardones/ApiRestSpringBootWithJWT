package com.example.demo.MODEL_ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmascota")
	private Long id;
	private String nombre;
	private String raza;

	public Mascota() {
	}

	public Mascota(Long id, String nombre, String raza) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
	}

}
