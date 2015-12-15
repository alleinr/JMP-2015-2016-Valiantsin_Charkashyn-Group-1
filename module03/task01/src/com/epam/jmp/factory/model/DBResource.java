package com.epam.jmp.factory.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBResource extends Resource{
	
	private Connection connection;

	public Connection getConnection() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			if (connection == null){
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:dbname","username","password");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
		
}
