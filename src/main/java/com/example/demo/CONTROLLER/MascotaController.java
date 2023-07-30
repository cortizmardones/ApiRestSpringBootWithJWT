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

import com.example.demo.MODEL_ENTITY.Mascota;
import com.example.demo.SERVICE.IMascotaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("mascota")
@Slf4j
public class MascotaController {

	@Autowired
	private IMascotaService iMascotaService;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Mascota mascota) {
		try {
			int result = iMascotaService.createMascota(mascota);
			if (result == 1) {
				return ResponseEntity.ok("Mascota: " + mascota.getNombre() + " insertada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Mascota> read(@PathVariable("id") Long id) {
		try {
			Optional<Mascota> optMascota = iMascotaService.readMascota(id);
			if (optMascota.isPresent()) {
				Mascota mascota = optMascota.get();
				return ResponseEntity.ok(mascota);
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Mascota mascota) {
		try {
			int result = iMascotaService.updateMascota(mascota);
			if (result == 1) {
				return ResponseEntity.ok("mascota ID: " + mascota.getId() + " actualizada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			int result = iMascotaService.deleteMascota(id);
			if (result == 1) {
				return ResponseEntity.ok("Mascota ID: " + id + " eliminada");
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Mascota>> listar() {
		List<Mascota> mascotaList = null;
		try {
			mascotaList = iMascotaService.readAllMascota();
			if (mascotaList != null && mascotaList.size() > 0) {
				return ResponseEntity.ok(mascotaList);
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return ResponseEntity.noContent().build();
	}

}
