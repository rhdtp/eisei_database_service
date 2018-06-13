package com.eisei.examen.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eisei.examen.modelo.Prueba;
import com.eisei.examen.repositorio.PruebaRepositorio;

@Controller
@RequestMapping("/api/v1")
public class PruebaControlador {

	@Autowired
	private PruebaRepositorio repositorio;

	@RequestMapping(value = "obtain", params = { "key" })
	public ResponseEntity<Prueba> obtain(@RequestParam("key") String key) {
		try {

			Prueba prueba = repositorio.findOne(key);

			if (prueba != null) {
				return ResponseEntity.ok(prueba);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
