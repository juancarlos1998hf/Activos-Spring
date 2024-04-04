package com.practica.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practica.models.entity.Activo;

@Repository
public interface ActivosRepository extends CrudRepository<Activo, Long> {

}
