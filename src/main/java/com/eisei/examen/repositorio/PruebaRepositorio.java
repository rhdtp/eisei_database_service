package com.eisei.examen.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eisei.examen.modelo.Prueba;

public interface PruebaRepositorio extends MongoRepository<Prueba, String> {

}
