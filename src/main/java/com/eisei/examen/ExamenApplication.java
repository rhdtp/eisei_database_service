package com.eisei.examen;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.eisei.examen.modelo.Prueba;
import com.eisei.examen.repositorio.PruebaRepositorio;

@ComponentScan
@EnableMongoRepositories
@SpringBootApplication
public class ExamenApplication {

	@Resource
	private PruebaRepositorio repository;

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

	@PostConstruct
	public void loadData() {
		List<Prueba> pruebas = new ArrayList<>();
		pruebas.add(new Prueba("test_eisei", 10));

		repository.save(pruebas);
	}
}
