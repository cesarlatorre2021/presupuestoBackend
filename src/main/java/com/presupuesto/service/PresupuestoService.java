package com.presupuesto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Sumatorias;
import com.presupuesto.entity.Totales;
import com.presupuesto.repository.PresupuestoRepository;

@Service
public class PresupuestoService {
	
	static final String INGRESO = "INGRESO";
	static final String GASTO = "GASTO";
	
	@Autowired
	private PresupuestoRepository presupuestoRepository;
	
	public List<Presupuesto> getAll(String idUsuario) {
		return presupuestoRepository.listarPresupuesto(idUsuario);
	}
	
	public Optional<Presupuesto> getByIdPresupuesto(String idPresupuesto) {
        return presupuestoRepository.getByIdPresupuesto(idPresupuesto);
    }
	
	public Presupuesto guardar(Presupuesto presupuesto) {
		return presupuestoRepository.save(presupuesto);
	}

	public boolean delete(String idPresupuesto) {
    	if (getByIdPresupuesto(idPresupuesto).isPresent() == true) {
    		presupuestoRepository.delete(idPresupuesto);
    		return true;
    	}else {
    		return false;
    	}   	
	}

	public Presupuesto modify(Presupuesto presupuesto) {
		return presupuestoRepository.modify(presupuesto);
	}
	
	public Sumatorias sumatorias(String idUsuario) {
		
		Sumatorias sumatorias = new Sumatorias();
		
		long sumaIngreso = 0;
		long sumaGasto = 0;
		long diferencia = 0;
		
		for(int i = 0; i < getAll(idUsuario).size(); i++) {
			if(getAll(idUsuario).get(i).getTipo().toUpperCase().equals(INGRESO)) {
				sumaIngreso = sumaIngreso + getAll(idUsuario).get(i).getValor();
			}else if(getAll(idUsuario).get(i).getTipo().toUpperCase().equals(GASTO)) {
				sumaGasto = sumaGasto + getAll(idUsuario).get(i).getValor();
			}
		}
		
		diferencia = (sumaIngreso - sumaGasto);
		
		sumatorias.setSumaIngresos(sumaIngreso);
		sumatorias.setSumaGastos(sumaGasto);
		sumatorias.setDiferencia(diferencia);
		
		return sumatorias;
	}
	
	public List<Totales> listarTotales(String idUsuario) {
		return presupuestoRepository.listarTotales(idUsuario);
	}

}
