package com.presupuesto.repository;

import java.util.Optional;

import com.presupuesto.entity.Autenticacion;

public interface AutenticacionRepository {
	
	Optional<Autenticacion> autenticar (String usuario, String password);
	Autenticacion nombreUsuario (String idUsuario);

}