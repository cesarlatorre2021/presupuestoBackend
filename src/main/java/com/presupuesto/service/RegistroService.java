package com.presupuesto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presupuesto.entity.Registro;
import com.presupuesto.repository.RegistroRepository;

@Service
public class RegistroService {
	
	@Autowired
	RegistroRepository registroRepository;
	
	public Registro save(Registro registro) {
		return registroRepository.save(registro);
	}

}
