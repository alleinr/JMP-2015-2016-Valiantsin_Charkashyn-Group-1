package com.epam.jmp.threads01.tool.datahandler;

import com.epam.jmp.threads01.menu.Output;
import com.epam.jmp.threads01.model.Bank;
import com.epam.jmp.threads01.model.Person;

public class ClientHandler {
	
	public Person createClient(){
		
		Output output = new Output();
		String id = output.enterId();
		String firstName = output.enterFirstName();
		String lastName = output.enterLastName();
		String status = output.enterStatus();		
		Person person = new Person(id, firstName, lastName, status);		
		
		return person;
	}

}
