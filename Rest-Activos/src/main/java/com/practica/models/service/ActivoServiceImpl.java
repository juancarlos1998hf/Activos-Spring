package com.practica.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.models.entity.Activo;

import com.practica.models.repository.ActivosRepository;

@Service
public class ActivoServiceImpl implements IActivosService {

	@Autowired
	private ActivosRepository activoRepository;
	
	@Override
	public List<Activo> listarTodos() {
		
		return (List<Activo>) activoRepository.findAll();
	}

	@Override
	public void guardar(Activo Activos) {
		activoRepository.save(Activos);
		
	}

	@Override
	public Activo buscarPorId(Long id) {
		
		return activoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		activoRepository.deleteById(id);
	}
	
}