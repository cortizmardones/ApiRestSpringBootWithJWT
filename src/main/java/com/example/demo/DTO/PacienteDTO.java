package com.example.demo.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteDTO {

	private Long id;
	private String rut;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

	public PacienteDTO() {

	}

	public PacienteDTO(Long id, String rut, String nombre, String apellido, LocalDate fechaNacimiento) {
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}


}
