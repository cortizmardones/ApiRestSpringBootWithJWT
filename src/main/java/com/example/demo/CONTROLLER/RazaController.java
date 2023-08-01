package com.example.demo.CONTROLLER;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MODEL_ENTITY.Raza;
import com.example.demo.SERVICE.IRazaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("raza")
@Slf4j
public class RazaController {
	
	@Autowired
	private IRazaService iRazaService;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Raza raza) {
		try {
			int result = iRazaService.createRaza(raza);
			if (result == 1) {
				return ResponseEntity.ok("Raza: " + raza.getNombre() + " insertada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Raza> read(@PathVariable("id") Long id) {
		try {
			Optional<Raza> optRaza = iRazaService.readRaza(id);
			if (optRaza.isPresent()) {
				Raza raza = optRaza.get();
				return ResponseEntity.ok(raza);
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Raza raza) {
		try {
			int result = iRazaService.updateRaza(raza);
			if (result == 1) {
				return ResponseEntity.ok("Raza ID: " + raza.getIdRaza() + " actualizada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			int result = iRazaService.deleteRaza(id);
			if (result == 1) {
				return ResponseEntity.ok("Raza ID: " + id + " eliminada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Raza>> listar() {
		List<Raza> razaList = null;
		try {
			razaList = iRazaService.readAllRaza();
			if (razaList != null && razaList.size() > 0) {
				return ResponseEntity.ok(razaList);
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

}
