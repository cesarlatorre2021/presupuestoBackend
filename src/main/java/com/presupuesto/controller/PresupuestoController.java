package com.presupuesto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Sumatorias;
import com.presupuesto.entity.SumatoriasMes;
import com.presupuesto.entity.TotalesGasto;
import com.presupuesto.entity.TotalesIngreso;
import com.presupuesto.service.PresupuestoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
//@CrossOrigin(origins = "http://app-presupuesto.s3-website.us-east-2.amazonaws.com")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class PresupuestoController {
	
	@Autowired
    private PresupuestoService presupuestoService;
	
    @GetMapping("/lista/{idUsuario}/{mesAnio}")
    @ApiOperation("Enlista todos los ingresos y gastos de un presupuesto personal")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Presupuesto>> getAll(@PathVariable String idUsuario, 
			@PathVariable(value = "mesAnio", required = false) String mesAnio){
    	return new ResponseEntity<> (presupuestoService.listarPresupuestoXMes(idUsuario,mesAnio), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    @ApiOperation("Guarda en la BD un nuevo registro del presupuesto, ya sea un ingreso o gasto")
	public ResponseEntity<Presupuesto> save(@RequestBody Presupuesto presupuesto) {
		return new ResponseEntity<> (presupuestoService.guardar(presupuesto), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
    @ApiOperation("Permite eliminar de la BD un registro del presupuesto")
   	public ResponseEntity delete (@PathVariable("id") String idPresupuesto) {
   		if(presupuestoService.delete(idPresupuesto) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
      
    @PutMapping("/actualizar")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Permite modificar de la BD un registro del presupuesto")
	public ResponseEntity<Presupuesto> modify(@RequestBody Presupuesto presupuesto) {
    	return new ResponseEntity<> (presupuestoService.modify(presupuesto), HttpStatus.OK);
	}
    
    @GetMapping("/sumatorias/{idUsuario}")
    @ApiOperation("Permite consultar el total general al año del presupuesto (Ingresos vs Gastos)")
	public ResponseEntity<Sumatorias> sumatorias(@PathVariable String idUsuario) {
    	return new ResponseEntity<> (presupuestoService.sumatorias(idUsuario), HttpStatus.OK);
	}
    
    @GetMapping("/sumatoriasMes/{idUsuario}/{mesAnio}")
    @ApiOperation("Permite consultar el total por mes de los ingresos o gastos del presupuesto")
	public ResponseEntity<SumatoriasMes> sumatoriasMes(@PathVariable String idUsuario, 
			@PathVariable(value = "mesAnio", required = false) String mesAnio) {
    	return new ResponseEntity<> (presupuestoService.sumatoriasMes(idUsuario, mesAnio), HttpStatus.OK);
	}
    
    @GetMapping("/lista/totales/{idUsuario}/{fechaInicial}/{fechaFinal}")
    @ApiOperation("Permite consultar los totales generales con respecto al Gasto")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<TotalesGasto>> getAllTotalesGasto(
			@PathVariable String idUsuario
		  , @PathVariable(value = "fechaInicial", required = false) String fechaInicial
		  , @PathVariable(value = "fechaFinal", required = false) String fechaFinal){	
    	return new ResponseEntity<> (presupuestoService.listarTotalesGasto(idUsuario,fechaInicial,fechaFinal), HttpStatus.OK);
    }
    
    @GetMapping("/lista/totales/ingresos/{idUsuario}")
    @ApiOperation("Permite consultar los totales generales con respecto al ingreso")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<TotalesIngreso>> getAllTotalesIngreso(@PathVariable String idUsuario){	
    	return new ResponseEntity<> (presupuestoService.listarTotalesIngreso(idUsuario), HttpStatus.OK);
    }
    
}
