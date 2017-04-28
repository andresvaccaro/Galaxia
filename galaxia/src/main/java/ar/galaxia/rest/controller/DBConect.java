package ar.galaxia.rest.controller;

import java.sql.*;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public final class DBConect {
	
	private static Connection con;
	private static DBConect dBConect;
	

	private DBConect() {
		super();
		Connection con = null;		

		try {
			con=this.dataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.con=con;
	}
	
	public static DBConect getInstancia(){
		if(dBConect==null){
			dBConect = new DBConect(); 			
		}
		return dBConect;
	}

	public Connection dameConexion() {		
		return this.con;
	}

	public DataSource dataSource() throws NamingException {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://ap-cdbr-azure-southeast-b.cloudapp.net:3306/db_alaxia?serverTimezone=UTC");
		basicDataSource.setUsername("b1fdbb2f33c32b");
		basicDataSource.setPassword("17308fa4");
		return basicDataSource;
	}
}
