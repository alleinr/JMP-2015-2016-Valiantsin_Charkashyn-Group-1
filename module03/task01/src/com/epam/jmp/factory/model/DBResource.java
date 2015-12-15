package com.epam.jmp.factory.model;

import java.sql.Connection;

public class DBResource extends Resource{
	
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
