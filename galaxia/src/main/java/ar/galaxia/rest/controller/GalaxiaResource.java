package ar.galaxia.rest.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ar.com.galaxia.rest.model.InformeClima;
import ar.com.galaxia.service.GalaxiaService;
import ar.com.galaxia.service.impl.GalaxiaServiceImpl;
import ar.galaxia.rest.model.DiaClima;

@Path("/climaWS")
public class GalaxiaResource {

	private GalaxiaService galaxiaService;

	public GalaxiaResource() {
		super();
		this.galaxiaService = new GalaxiaServiceImpl();
	}

	@GET
	@Path("/clima")
	@Produces(MediaType.APPLICATION_JSON)
	public DiaClima obtenerClimaDia(@QueryParam("dia") int dia) throws SQLException {
//		this.galaxiaService.calcularProyeccionDeClimaEn10Anios();
		DiaClima diaCLima=this.galaxiaService.obtenerClimaDia(dia);		
		return diaCLima;
	}

	@GET
	@Path("/informeClima")
	@Produces(MediaType.APPLICATION_JSON)
	public InformeClima obtenerInformeClimaPorximosAnios(@QueryParam("cantidadAnios") int anios) {
		InformeClima informeClima = this.galaxiaService.obtenerInformeClimaDuranteLosProximosAnios(anios);
		return informeClima;
	}

	
	@GET
	@Path("/proyeccion")
	@Produces(MediaType.APPLICATION_JSON)
	public String calcularProyeccionDeClimaEnAnios(@QueryParam("anios") int anios) throws SQLException {
		this.galaxiaService.calcularProyeccionDeClimaEnAnios(anios);
				
		return "Ejecucion finalizada";
	}
}
