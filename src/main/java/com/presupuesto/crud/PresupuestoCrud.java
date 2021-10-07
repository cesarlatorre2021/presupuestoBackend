package com.presupuesto.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.presupuesto.entity.Presupuesto;
import com.presupuesto.entity.TotalesGasto;
import com.presupuesto.entity.TotalesIngreso;

public interface PresupuestoCrud extends CrudRepository <Presupuesto, String>{
	
	@Query(value = "SELECT ID_PRESUPUESTO "
			+ "           ,TO_DATE(TO_CHAR(FECHA, 'DD/MM/YYYY'), 'DD/MM/YYYY') AS FECHA"
			+ "           ,TIPO"
			+ "           ,CATEGORIA"
			+ "           ,DESCRIPCION"
			+ "           ,VALOR "
			+ "           ,ID_USUARIO"
			+ "       FROM INFO_PRESUPUESTO"
			+ "      WHERE ID_USUARIO = :idUsuario"
			+ "      ORDER BY FECHA DESC", nativeQuery = true)
	List<Presupuesto> listarPresupuesto(@Param("idUsuario") String idUsuario);
	
	@Query(value = "SELECT ID_PRESUPUESTO "
			+ "           ,TO_DATE(TO_CHAR(FECHA, 'DD/MM/YYYY'), 'DD/MM/YYYY') + 1 AS FECHA"
			+ "           ,TIPO"
			+ "           ,CATEGORIA"
			+ "           ,DESCRIPCION"
			+ "           ,VALOR "
			+ "           ,ID_USUARIO"
			+ "       FROM INFO_PRESUPUESTO"
			+ "      WHERE ID_USUARIO = :idUsuario"
			+ "        AND TO_CHAR(FECHA,'MM-YYYY') = :mesAnio "
			+ "      ORDER BY FECHA DESC", nativeQuery = true)
	List<Presupuesto> listarPresupuestoXMes(@Param("idUsuario") String idUsuario,
											@Param("mesAnio") String mesAnio);
	
	@Query(value = "SELECT CATEGORIA "
			+ "           ,TRIM(TO_CHAR(SUM(VALOR), '$999,999,999')) TOTALGRUPO "
			+ "           ,ROUND(100*(SUM(VALOR) / SUM(SUM(VALOR)) OVER ()),2) PORCENTAJE "
			+ "       FROM INFO_PRESUPUESTO "
			+ "      WHERE UPPER(TIPO) = 'GASTO' "
			+ "        AND ID_USUARIO = :idUsuario"
			+ "      GROUP BY CATEGORIA "
			+ "      ORDER BY PORCENTAJE DESC", nativeQuery = true)
	List<TotalesGasto> listarTotalesGasto(@Param("idUsuario") String idUsuario);
	
	@Query(value = "SELECT CATEGORIA "
			+ "           ,TRIM(TO_CHAR(SUM(VALOR), '$999,999,999')) TOTALGRUPO "
			+ "           ,ROUND(100*(SUM(VALOR) / SUM(SUM(VALOR)) OVER ()),2) PORCENTAJE "
			+ "       FROM INFO_PRESUPUESTO "
			+ "      WHERE UPPER(TIPO) = 'INGRESO' "
			+ "        AND ID_USUARIO = :idUsuario"
			+ "      GROUP BY CATEGORIA "
			+ "      ORDER BY PORCENTAJE DESC", nativeQuery = true)
	List<TotalesIngreso> listarTotalesIngreso(@Param("idUsuario") String idUsuario);

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
