package com.presupuesto.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFO_PRESUPUESTO")
public class Presupuesto {
	
	@Id
	@Column(name = "ID_PRESUPUESTO")
	private String idPresupuesto;
	private Date fecha;
	private String tipo;
	private String categoria;
	private String descripcion;
	private long valor;
	
	@Column(name = "ID_USUARIO")
	private String idUsuario;
	
	public String getIdPresupuesto() {
		return idPresupuesto;
	}
	
	public void setIdPresupuesto(String idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public long getValor() {
		return valor;
	}
	
	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
