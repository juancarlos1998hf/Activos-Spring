package com.practica.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practica.models.entity.Activo;
import com.practica.models.service.IActivosService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("views/activos")
public class ActivosController {
	
	@Autowired
	private IActivosService clienteService;
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Activo> listaClientes = clienteService.listarTodos();
		model.addAttribute("titulo", "Lista de Activos");
		model.addAttribute("activos", listaClientes);
		return "/views/activos/listar";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		Activo activo = new Activo();
		List<Activo> listActivos = clienteService.listarTodos();
		
		
		model.addAttribute("titulo","Formulario Nuevo Activo");
		model.addAttribute("activos",activo);
		model.addAttribute("listaActivos",listActivos);
		return "/views/activos/frmCrear";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Activo activo, BindingResult result,
			Model model, RedirectAttributes attribute) {
	
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Activo");
			model.addAttribute("activos", activo);
			System.out.println("Existieron errores en el formulario");			
			return "/views/activos/frmCrear";
		}

		clienteService.guardar(activo);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con exito!");
		return "redirect:/views/activos/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idCliente, Model model) {
		Activo activo = clienteService.buscarPorId(idCliente);
		
		
		model.addAttribute("titulo","Formulario: Editar Cliente");
		model.addAttribute("activos",activo);
		
		return "/views/activos/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idActivo) {
		clienteService.eliminar(idActivo);
		System.out.println("eliminado");
		return "redirect:/views/activos/";
	}
	
	
	
	@GetMapping(value="/buscar/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Activo data  = clienteService.buscarPorId(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
	

	
	
}
