package com.epam.jmp.facade.facade;

import java.sql.Connection;

import com.epam.jmp.facade.connection.DBConnect;
import com.epam.jmp.facade.tool.ConsoleTool;

public class Facade {
	
	public void connect(){
		
		ConsoleTool consoleTool = new ConsoleTool();
		
		System.out.println("Enter dbname: ");
		String dbname = consoleTool.takeInput();
		System.out.println("Enter username: ");
		String username = consoleTool.takeInput();
		System.out.println("Enter password: ");
		String password = consoleTool.takeInput();		
		Connection connection = new DBConnect().createConnection(dbname, username, password);	
		if (connection != null){
			System.out.println(connection);
		} else {
			System.out.println("Connection wasn't established!");
		}
		
		
	}
}
