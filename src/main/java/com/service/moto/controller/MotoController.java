package com.service.moto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.moto.entity.Moto;
import com.service.moto.servicios.MotoServicio;

@RestController
@RequestMapping("/moto")
public class MotoController {
	
	@Autowired
	MotoServicio motoServicio;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Moto>> litarMoto(){
		List<Moto> listaMoto = motoServicio.listar();
		if(listaMoto.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(listaMoto);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Moto> buscarMoto(@PathVariable("id") int id){
		Moto moto = motoServicio.buscarMoto(id);
		if(moto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Moto> crearMoto(@RequestBody Moto moto){
		return new ResponseEntity<Moto>(motoServicio.crearMoto(moto),HttpStatus.CREATED);
	}
	
	@GetMapping("/listarUsuario/{id}")
	public ResponseEntity<List<Moto>> buscarUsuario(@PathVariable("id") int id){
		List<Moto> moto = motoServicio.buscarUsuario(id);
		return ResponseEntity.ok(moto);
	}

}
