package com.presupuesto.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.presupuesto.crud.PresupuestoCrud;
import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Totales;
import com.presupuesto.repository.PresupuestoRepository;

@Repository
public class PresupuestoRepositoryImpl implements PresupuestoRepository{
	
	@Autowired
	PresupuestoCrud presupuestoCrud;

	@Override
	public List<Presupuesto> listarPresupuesto() {
		return presupuestoCrud.listarPresupuesto();
	}
	
	@Override
	public Presupuesto save(Presupuesto presupuesto) {
		return presupuestoCrud.save(presupuesto);
	}

	@Override
	public void delete(String idPresupuesto) {
		presupuestoCrud.deleteById(idPresupuesto);
	}

	@Override
	public Optional<Presupuesto> getByIdPresupuesto(String idPresupuesto) {
		return presupuestoCrud.findById(idPresupuesto);
	}

	@Override
	public Presupuesto modify(Presupuesto presupuesto) {
		presupuestoCrud.modify(
				presupuesto.getFecha(), 
				presupuesto.getTipo(),
				presupuesto.getCategoria(), 
				presupuesto.getDescripcion(), 
				presupuesto.getValor(), 
				presupuesto.getIdPresupuesto()
		);
		return presupuesto;
	}

	@Override
	public List<Totales> listarTotales() {
		return presupuestoCrud.listarTotales();
	}

}
