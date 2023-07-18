package com.service.moto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.moto.entity.Moto;
import com.service.moto.repository.MotoRepository;

@Service
public class MotoServicio {

	@Autowired
	MotoRepository motoRepository;
	
	public List<Moto> listar(){
		List<Moto> listaMoto = motoRepository.findAll();
		//Mayor a Menor
		listaMoto.sort((Moto m1, Moto m2) ->m1.getId()-m2.getId());
		//Menor a mayor
		//listaMoto.sort((Moto m1, Moto m2) ->m2.getId()-m1.getId());
		return listaMoto;
	}
	
	public Moto crearMoto(Moto moto) {
		return motoRepository.save( moto);
	}
	
	public Moto buscarMoto(int id) {
		return motoRepository.findById(id).orElse(null);
	}
	
	public List<Moto> buscarUsuario(int id){
		return motoRepository.findByUserId(id);
	}
}
