package com.presupuesto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presupuesto.entity.Autenticacion;
import com.presupuesto.entity.Notificacion;
import com.presupuesto.repository.AutenticacionRepository;

@Service
public class AutenticacionService {
	
	@Autowired
	AutenticacionRepository autenticacionRepository;
	
	public Notificacion autenticar(String usuario, String password) {
		
		Notificacion notificacion = new Notificacion();
		
		if (autenticacionRepository.autenticar(usuario, password).isEmpty()) {
			notificacion.setEstado("ER");
			notificacion.setMensaje("No Autenticado");
			notificacion.setId("");
		}else {
			notificacion.setEstado("OK");
			notificacion.setMensaje("Autenticado");
			notificacion.setId(autenticacionRepository.autenticar(usuario, password).get().getIdUsuario());
		}
		
		return notificacion;
	}
	
	public Autenticacion nombreUsuario(String idUsuario) {
		return autenticacionRepository.nombreUsuario(idUsuario);
	}

}
