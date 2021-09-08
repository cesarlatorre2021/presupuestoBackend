package com.presupuesto.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.Totales;

public interface PresupuestoCrud extends CrudRepository <Presupuesto, String>{
	
	@Query(value = "SELECT ID_PRESUPUESTO "
			+ "           ,TO_DATE(TO_CHAR(FECHA, 'DD/MM/YYYY'), 'DD/MM/YYYY') AS FECHA"
			+ "           ,TIPO"
			+ "           ,CATEGORIA"
			+ "           ,DESCRIPCION"
			+ "           ,VALOR "
			+ "       FROM INFO_PRESUPUESTO"
			+ "      ORDER BY FECHA DESC", nativeQuery = true)
	List<Presupuesto> listarPresupuesto();
	
	@Query(value = "SELECT CATEGORIA "
			+ "           ,TRIM(TO_CHAR(SUM(VALOR), '$999,999,999')) TOTALGRUPO "
			+ "           ,ROUND(100*(SUM(VALOR) / SUM(SUM(VALOR)) OVER ()),2) PORCENTAJE "
			+ "       FROM INFO_PRESUPUESTO "
			+ "      WHERE UPPER(TIPO) = 'GASTO' "
			+ "      GROUP BY CATEGORIA "
			+ "      ORDER BY PORCENTAJE DESC", nativeQuery = true)
	List<Totales> listarTotales();

	@Modifying
	@Transactional
	@Query(value = "UPDATE INFO_PRESUPUESTO "
			+ "        SET FECHA = :fecha"
			+ "           ,TIPO = :tipo"
			+ "           ,CATEGORIA = :categoria"
			+ "           ,DESCRIPCION = :descripcion"
			+ "           ,VALOR = :valor"
			+ "      WHERE ID_PRESUPUESTO = :idPresupuesto", nativeQuery = true)
	Object modify(@Param("fecha") Date fecha,
                  @Param("tipo") String tipo,
                  @Param("categoria") String categoria,
                  @Param("descripcion") String descripcion,
                  @Param("valor") long valor,
			      @Param("idPresupuesto") String idPresupuesto);

}
