package com.practica.models.service;

import java.util.List;

import com.practica.models.entity.Activo;



public interface IActivosService {
	public List<Activo> listarTodos();
	public void guardar(Activo Activos);
	public Activo buscarPorId(Long id);
	public void eliminar(Long id);
}
