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
	private long sumaIngreso;
	private long sumaGasto;
	private long diferencia;
	private long sumaIngresoMes;
	private long sumaGastoMes;
	private long diferenciaMes;
		
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
		
		sumaIngreso = 0;
		sumaGasto = 0;
		diferencia = 0;
		
		Sumatorias sumatorias = new Sumatorias();
		
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
		
		sumaIngresoMes = 0;
		sumaGastoMes = 0;
		diferenciaMes = 0;
		
		SumatoriasMes sumatorias = new SumatoriasMes();
	
		for(int i = 0; i < listarPresupuestoXMes(idUsuario,mesAnio).size(); i++) {
			if(listarPresupuestoXMes(idUsuario,mesAnio).get(i).getTipo().toUpperCase().equals(INGRESO)) {
				sumaIngresoMes = sumaIngresoMes + listarPresupuestoXMes(idUsuario,mesAnio).get(i).getValor();
			}else if(listarPresupuestoXMes(idUsuario,mesAnio).get(i).getTipo().toUpperCase().equals(GASTO)) {
				sumaGastoMes = sumaGastoMes + listarPresupuestoXMes(idUsuario,mesAnio).get(i).getValor();
			}
		}
		
		diferenciaMes = (sumaIngresoMes - sumaGastoMes);
		
		sumatorias.setSumaIngresos(sumaIngresoMes);
		sumatorias.setSumaGastos(sumaGastoMes);
		sumatorias.setDiferencia(diferenciaMes);
		
		return sumatorias;
	}
	
	public List<TotalesGasto> listarTotalesGasto(String idUsuario, String fechaInicial, String fechaFinal) {
		return presupuestoRepository.listarTotalesGasto(idUsuario, fechaInicial, fechaFinal);
	}
	
	public List<TotalesIngreso> listarTotalesIngreso(String idUsuario) {
		return presupuestoRepository.listarTotalesIngreso(idUsuario);
	}

}
