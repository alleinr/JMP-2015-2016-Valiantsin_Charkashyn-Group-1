package com.epam.jmp.facade.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect{

	public Connection createConnection(String dbname, String username, String password) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			if (connection == null){
				connection = DriverManager.getConnection(dbname, username, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}		
}
