package com.presupuesto.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.presupuesto.entity.Autenticacion;

public interface AutenticacionCrud extends CrudRepository <Autenticacion, String> {
	
	@Query(value = "SELECT * "
			+ "       FROM USUARIO "
			+ "      WHERE USUARIO = :usuario "
			+ "        AND PASSWORD = :password ", nativeQuery = true)
	Optional<Autenticacion> autenticar(@Param("usuario") String usuario, @Param("password") String password);
	
	@Query(value = "SELECT * "
			+ "       FROM USUARIO "
			+ "      WHERE ID_USUARIO = :idUsuario ", nativeQuery = true)
	Autenticacion nombreUsuario(@Param("idUsuario") String idUsuario);
	
}
