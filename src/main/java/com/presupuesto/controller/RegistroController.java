package com.presupuesto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presupuesto.entity.Registro;
import com.presupuesto.service.RegistroService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://app-presupuesto.s3-website.us-east-2.amazonaws.com")
@RequestMapping("registro")
public class RegistroController {
	
	@Autowired 
	RegistroService registroService;
	
    @PostMapping("/save")
    @ApiOperation("Guarda en la BD una nueva area de la empresa")
	public ResponseEntity<Registro> save(@RequestBody Registro registro) {
		return new ResponseEntity<> (registroService.save(registro), HttpStatus.CREATED);
	}
    
}
