package com.presupuesto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Sumatorias;
import com.presupuesto.entity.SumatoriasMes;
import com.presupuesto.entity.TotalesGasto;
import com.presupuesto.entity.TotalesIngreso;
import com.presupuesto.repository.PresupuestoRepository;

@Service
public class PresupuestoService {
	
	static final String INGRESO = "INGRESO";
	static final String GASTO = "GASTO";
	
	@Autowired
	private PresupuestoRepository presupuestoRepository;
	
	public List<Presupuesto> listarPresupuesto(String idUsuario) {
		return presupuestoRepository.listarPresupuesto(idUsuario);
	}
	
	
	public List<Presupuesto> listarPresupuestoXMes(String idUsuario, String mesAnio) {
		return presupuestoRepository.listarPresupuestoXMes(idUsuario, mesAnio);
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
		
		for(int i = 0; i < listarPresupuesto(idUsuario).size(); i++) {
			if(listarPresupuesto(idUsuario).get(i).getTipo().toUpperCase().equals(INGRESO)) {
				sumaIngreso = sumaIngreso + listarPresupuesto(idUsuario).get(i).getValor();
			}else if(listarPresupuesto(idUsuario).get(i).getTipo().toUpperCase().equals(GASTO)) {
				sumaGasto = sumaGasto + listarPresupuesto(idUsuario).get(i).getValor();
			}
		}
		
		diferencia = (sumaIngreso - sumaGasto);
		
		sumatorias.setSumaIngresos(sumaIngreso);
		sumatorias.setSumaGastos(sumaGasto);
		sumatorias.setDiferencia(diferencia);
		
		return sumatorias;
	}
	
	public SumatoriasMes sumatoriasMes(String idUsuario,String mesAnio) {
		
		SumatoriasMes sumatorias = new SumatoriasMes();
		
		long sumaIngreso = 0;
		long sumaGasto = 0;
		long diferencia = 0;
		
		for(int i = 0; i < listarPresupuestoXMes(idUsuario,mesAnio).size(); i++) {
			if(listarPresupuestoXMes(idUsuario,mesAnio).get(i).getTipo().toUpperCase().equals(INGRESO)) {
				sumaIngreso = sumaIngreso + listarPresupuestoXMes(idUsuario,mesAnio).get(i).getValor();
			}else if(listarPresupuestoXMes(idUsuario,mesAnio).get(i).getTipo().toUpperCase().equals(GASTO)) {
				sumaGasto = sumaGasto + listarPresupuestoXMes(idUsuario,mesAnio).get(i).getValor();
			}
		}
		
		diferencia = (sumaIngreso - sumaGasto);
		
		sumatorias.setSumaIngresos(sumaIngreso);
		sumatorias.setSumaGastos(sumaGasto);
		sumatorias.setDiferencia(diferencia);
		
		return sumatorias;
	}
	
	public List<TotalesGasto> listarTotalesGasto(String idUsuario) {
		return presupuestoRepository.listarTotalesGasto(idUsuario);
	}
	
	public List<TotalesIngreso> listarTotalesIngreso(String idUsuario) {
		return presupuestoRepository.listarTotalesIngreso(idUsuario);
	}

}
