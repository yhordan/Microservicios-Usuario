package com.service.moto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.moto.entity.Moto;

public interface MotoRepository extends JpaRepository<Moto, Integer>{
	
	public List<Moto> findByUserId(int userId);

}
