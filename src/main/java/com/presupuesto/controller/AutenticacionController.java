package com.presupuesto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.presupuesto.entity.Notificacion;
import com.presupuesto.service.AutenticacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://presupuesto-app2.s3-website.us-east-2.amazonaws.com")
@RequestMapping("")
public class AutenticacionController {
	
	@Autowired
	AutenticacionService autenticacionService;
	
    @GetMapping("/autenticacion/{usuario}/{password}")
    @ApiOperation("Permite realizar la autenticación de la app")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Autenticación not found"),
    	@ApiResponse(code = 500, message = "Internal Server Error")
    })
	public ResponseEntity<Notificacion> autenticar(
			@ApiParam(value = "Autenticación de la App", required = true, example ="1") 
			@PathVariable("usuario") String usuario, @PathVariable("password") String password)
    {
	   return new ResponseEntity<> (autenticacionService.autenticar(usuario, password), HttpStatus.OK);
	}

}
