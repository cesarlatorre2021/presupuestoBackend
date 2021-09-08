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
import com.presupuesto.entity.Totales;
import com.presupuesto.service.PresupuestoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class PresupuestoController {
	
	@Autowired
    private PresupuestoService presupuestoService;
	
    @GetMapping("/lista")
    @ApiOperation("Enlista todas los activos fijos que tiene la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Presupuesto>> getAll(){	
    	return new ResponseEntity<> (presupuestoService.getAll(), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    @ApiOperation("Guarda en la BD una nueva area de la empresa")
	public ResponseEntity<Presupuesto> save(@RequestBody Presupuesto presupuesto) {
		return new ResponseEntity<> (presupuestoService.guardar(presupuesto), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
    @ApiOperation("Permite eliminar de la BD una area de la empresa")
   	public ResponseEntity delete (@PathVariable("id") String idPresupuesto) {
   		if(presupuestoService.delete(idPresupuesto) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
      
    @PutMapping("/actualizar")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Permite modificar de la BD el registro de alguna area de la empresa")
	public ResponseEntity<Presupuesto> modify(@RequestBody Presupuesto presupuesto) {
    	return new ResponseEntity<> (presupuestoService.modify(presupuesto), HttpStatus.OK);
	}
    
    @GetMapping("/sumatorias")
    @ApiOperation("Permite modificar de la BD el registro de alguna area de la empresa")
	public ResponseEntity<Sumatorias> sumatorias() {
    	return new ResponseEntity<> (presupuestoService.sumatorias(), HttpStatus.OK);
	}
    
    @GetMapping("/lista/totales")
    @ApiOperation("Enlista todas los activos fijos que tiene la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Totales>> getAllTotales(){	
    	return new ResponseEntity<> (presupuestoService.listarTotales(), HttpStatus.OK);
    }
    
}
