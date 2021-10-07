package com.presupuesto.repository;

import java.util.List;
import java.util.Optional;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.TotalesGasto;
import com.presupuesto.entity.TotalesIngreso;

public interface PresupuestoRepository {
	
	List<Presupuesto> listarPresupuesto(String idUsuario);
	List<Presupuesto> listarPresupuestoXMes(String idUsuario, String mesAnio);
	Presupuesto save(Presupuesto presupuesto);
	void delete(String idPresupuesto);
	Optional<Presupuesto> getByIdPresupuesto(String idPresupuesto);
	Presupuesto modify(Presupuesto presupuesto);
	List<TotalesGasto> listarTotalesGasto(String idUsuario);
	List<TotalesIngreso> listarTotalesIngreso(String idUsuario);

}
