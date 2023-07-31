package com.example.demo.MODEL_ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne
	//Name tabla Mascota y referencedColumName tabla Raza
	@JoinColumn(name = "idraza" , referencedColumnName = "idraza")
	private Raza raza;

	public Mascota() {
	}

	public Mascota(Long id, String nombre, Raza raza) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
	}

}
