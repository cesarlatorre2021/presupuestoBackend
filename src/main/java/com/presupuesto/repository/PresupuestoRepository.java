package com.presupuesto.repository;

import java.util.List;
import java.util.Optional;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Totales;

public interface PresupuestoRepository {
	
	List<Presupuesto> listarPresupuesto();
	Presupuesto save(Presupuesto presupuesto);
	void delete(String idPresupuesto);
	Optional<Presupuesto> getByIdPresupuesto(String idPresupuesto);
	Presupuesto modify(Presupuesto presupuesto);
	List<Totales> listarTotales();

}
