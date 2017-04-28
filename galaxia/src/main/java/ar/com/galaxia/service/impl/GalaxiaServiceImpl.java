package ar.com.galaxia.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.galaxia.constants.DistanciaAlSolConstant;
import ar.com.galaxia.constants.VelocidadAngularConstant;
import ar.com.galaxia.dao.GalaxiaDAO;
import ar.com.galaxia.dao.impl.GalaxiaDAOImpl;
import ar.com.galaxia.enumerados.CondicionClimaticaEnum;
import ar.com.galaxia.enumerados.SentidoEnum;
import ar.com.galaxia.model.Galaxia;
import ar.com.galaxia.model.Planeta;
import ar.com.galaxia.rest.model.InformeClima;
import ar.com.galaxia.service.GalaxiaService;
import ar.galaxia.rest.controller.DBConect;
import ar.galaxia.rest.model.DiaClima;

public class GalaxiaServiceImpl implements GalaxiaService {

	private GalaxiaDAO galaxiaDAO;
	
	public InformeClima obtenerInformeClimaDuranteLosProximosAnios(int anios) {
		InformeClima informeClima = new InformeClima();

		List<Planeta> planetas = new ArrayList<Planeta>();
		Planeta ferengi = new Planeta(0D, VelocidadAngularConstant.VELOCIDAD_FERENGI, SentidoEnum.HORARIO,
				DistanciaAlSolConstant.DISTANCIA_FERENGI);
		Planeta betasoide = new Planeta(0D, VelocidadAngularConstant.VELOCIDAD_BETASOIDE, SentidoEnum.HORARIO,
				DistanciaAlSolConstant.DISTANCIA_BETASOIDE);
		Planeta vulcano = new Planeta(0D, VelocidadAngularConstant.VELOCIDAD_VULCANO, SentidoEnum.ANTIHORARIO,
				DistanciaAlSolConstant.DISTANCIA_VULCANO);
		planetas.add(ferengi);
		planetas.add(betasoide);
		planetas.add(vulcano);

		Galaxia galaxia = new Galaxia(planetas);

		for (int i = 0; i < anios * 365; i++) {
			CondicionClimaticaEnum condicionDelDia = galaxia.obtenerCondicionClimaticaActual();
			informeClima.incrementar(condicionDelDia, i);
			galaxia.avanzarDia();
		}
		return informeClima;
	}

	public void calcularProyeccionDeClimaEn10Anios() throws SQLException {		
		Galaxia galaxia= new Galaxia();
		this.galaxiaDAO = new GalaxiaDAOImpl();
		this.galaxiaDAO.limpiarDatos();
//		List<DiaClima> todosLosDias = this.galaxiaDAO.obtenerClimaTodosLosDias();
//		List<DiaClima> diasClimas= new ArrayList<DiaClima>();
		for (int i = 1; i < 10*365; i++) {
			DiaClima diaCLima= new DiaClima();
			diaCLima.setClima(galaxia.obtenerCondicionClimaticaActual().getDescripcion());
			diaCLima.setDia(i);
//			diasClimas.add(diaCLima);
			this.galaxiaDAO.guardarDiaClima(diaCLima);
			galaxia.avanzarDia();
			
		}				
//		this.galaxiaDAO.guardarDiaClima(diasClimas);
	}

	public DiaClima obtenerClimaDia(int dia) throws SQLException {
		this.galaxiaDAO = new GalaxiaDAOImpl();
		return this.galaxiaDAO.obtenerClimaDia(dia);
	}

	public void calcularProyeccionDeClimaEnAnios(int anios) throws SQLException {
		Galaxia galaxia= new Galaxia();
		this.galaxiaDAO = new GalaxiaDAOImpl();
		this.galaxiaDAO.limpiarDatos();
//		List<DiaClima> todosLosDias = this.galaxiaDAO.obtenerClimaTodosLosDias();
//		List<DiaClima> diasClimas= new ArrayList<DiaClima>();
		for (int i = 1; i < anios*365; i++) {
			DiaClima diaCLima= new DiaClima();
			diaCLima.setClima(galaxia.obtenerCondicionClimaticaActual().getDescripcion());
			diaCLima.setDia(i);
//			diasClimas.add(diaCLima);
			this.galaxiaDAO.guardarDiaClima(diaCLima);
			galaxia.avanzarDia();
			
		}				
//		this.galaxiaDAO.guardarDiaClima(diasClimas);
	}

}
