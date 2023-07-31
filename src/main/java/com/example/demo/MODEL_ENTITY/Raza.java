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
@Table(name = "raza")
public class Raza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idraza")
	private Long id;
	private String nombre;

	public Raza() {
		super();
	}
	
	public Raza(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

}
