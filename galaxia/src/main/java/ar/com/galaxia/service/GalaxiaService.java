package ar.com.galaxia.service;

import java.sql.SQLException;

import ar.com.galaxia.rest.model.InformeClima;
import ar.galaxia.rest.model.DiaClima;

public interface GalaxiaService {

	InformeClima obtenerInformeClimaDuranteLosProximosAnios(int anios);

	void calcularProyeccionDeClimaEn10Anios() throws SQLException;

	DiaClima obtenerClimaDia(int dia) throws SQLException;

	void calcularProyeccionDeClimaEnAnios(int anios) throws SQLException;

}
