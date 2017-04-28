package ar.com.galaxia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.galaxia.dao.GalaxiaDAO;
import ar.galaxia.rest.controller.DBConect;
import ar.galaxia.rest.model.DiaClima;

public class GalaxiaDAOImpl implements GalaxiaDAO {

	public void guardarDiaClima(DiaClima diaCLima) throws SQLException {
		DBConect dbConect =  DBConect.getInstancia();
		Connection con = dbConect.dameConexion();
		String query = " insert into DIA_CLIMA VALUES  (?, ?)";

		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, diaCLima.getDia());
			preparedStmt.setString(2, diaCLima.getClima());
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStmt.close();		
		}

	}

	public void limpiarDatos() throws SQLException {
		DBConect dbConect =  DBConect.getInstancia();
		Connection con = dbConect.dameConexion();
		String query = "TRUNCATE TABLE DIA_CLIMA ";		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStmt!=null){
				preparedStmt.close();	
			}
						
		}

	}

	public DiaClima obtenerClimaDia(int dia) throws SQLException {
		DiaClima diaClima = new DiaClima();

		DBConect dbConect =  DBConect.getInstancia();
		Connection con = dbConect.dameConexion();

		PreparedStatement sentencias = null;
		ResultSet rs = null;

		try {
			
			StringBuffer sql = new StringBuffer("SELECT * FROM DIA_CLIMA WHERE DIA=?");			
			sentencias = con.prepareStatement(sql.toString());
			sentencias.setInt(1, dia);
			rs = sentencias.executeQuery(sql.toString());

			while (rs.next()) {
				diaClima.setClima(rs.getString(2));
				diaClima.setDia(rs.getInt(1));
			}
			if (diaClima.getClima() == null) {
				diaClima.setDia(dia);
				diaClima.setClima("No hay datos para ese dia");
			}
		} catch (SQLException e) {
			diaClima.setDia(0);
			diaClima.setClima("No se pudo determinar");

		} finally {
			if(sentencias!=null){
				sentencias.close();
			}
				
			if(rs!=null){
				rs.close();	
			}			
			
		}
		return diaClima;
	}

	public List<DiaClima> obtenerClimaTodosLosDias() throws SQLException {
		List<DiaClima> todosLosDias = new ArrayList<DiaClima>();
		DBConect dbConect =  DBConect.getInstancia();		
		Connection con = dbConect.dameConexion();

		Statement sentencias = null;
		ResultSet rs = null;

		try {
			sentencias = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			StringBuffer sql = new StringBuffer("SELECT * FROM DIA_CLIMA");
			rs = sentencias.executeQuery(sql.toString());

			while (rs.next()) {
				DiaClima diaClima = new DiaClima();
				diaClima.setClima(rs.getString(2));
				diaClima.setDia(rs.getInt(1));
				todosLosDias.add(diaClima);
			}

		} catch (SQLException e) {
			throw e;

		} finally {
			if(sentencias!=null){
				sentencias.close();
			}
				
			if(rs!=null){
				rs.close();	
			}		
		}
		return todosLosDias;

	}




}
