package com.presupuesto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Registro {
	
	@Id
	@Column(name = "ID_USUARIO")
	private String idUsuario;
	
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	
	@Column(name = "CORREO_ELECTRONICO")
	private String correoElectronico;
	
	private String usuario;
	
	private String password;
	
	@Column(name = "SN_SESSION")
	private String snSession;
	
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
	
	public String getPrimerNombre() {
		return primerNombre;
	}
	
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	
	public String getSegundoNombre() {
		return segundoNombre;
	}
	
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSnSession() {
		return snSession;
	}

	public void setSnSession(String snSession) {
		this.snSession = snSession;
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
