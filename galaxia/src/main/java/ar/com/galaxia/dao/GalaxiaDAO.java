package ar.com.galaxia.dao;

import java.sql.SQLException;
import java.util.List;

import ar.galaxia.rest.model.DiaClima;

public interface GalaxiaDAO {

	void guardarDiaClima(DiaClima diaCLima) throws SQLException;

	void limpiarDatos() throws SQLException;

	DiaClima obtenerClimaDia(int dia) throws SQLException;

	List<DiaClima> obtenerClimaTodosLosDias() throws SQLException;

	void guardarDiaClima(List<DiaClima> diasClimas) throws SQLException;

}
