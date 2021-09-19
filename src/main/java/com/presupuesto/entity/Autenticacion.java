package com.presupuesto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "USUARIO")
public class Autenticacion {
	
	@Id
	@Column(name = "ID_USUARIO")
	private String idUsuario;
	
	@Column(name = "USUARIO")
	private String nombreUsuario;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
