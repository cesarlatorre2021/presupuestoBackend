package com.presupuesto.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.presupuesto.crud.AutenticacionCrud;
import com.presupuesto.entity.Autenticacion;
import com.presupuesto.repository.AutenticacionRepository;

@Repository
public class AutenticacionRepositoryImpl implements AutenticacionRepository {
	
	@Autowired
	AutenticacionCrud autenticacionCrud;
	
	@Override
	public Optional<Autenticacion> autenticar(String usuario, String password) {
		return autenticacionCrud.autenticar(usuario, password);
	}

	@Override
	public Autenticacion nombreUsuario(String idUsuario) {
		return autenticacionCrud.nombreUsuario(idUsuario);
	}

}
