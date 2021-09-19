package com.presupuesto.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.presupuesto.crud.RegistroCrud;
import com.presupuesto.entity.Registro;
import com.presupuesto.repository.RegistroRepository;

@Repository
public class RegistroRepositoryImpl implements RegistroRepository{
	
	@Autowired
	RegistroCrud registroCrud;

	@Override
	public Registro save(Registro registro) {
		return registroCrud.save(registro);
	}

}
