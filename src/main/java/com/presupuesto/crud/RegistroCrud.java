package com.presupuesto.crud;

import org.springframework.data.repository.CrudRepository;

import com.presupuesto.entity.Registro;

public interface RegistroCrud extends CrudRepository <Registro, String>{}
