package com.epam.jpa.task03.tool.datahandler;

import com.epam.jpa.task03.menu.Output;
import com.epam.jpa.task03.model.Bank;
import com.epam.jpa.task03.model.Person;

public class PersonHandler {
	
	public Person createClient(){
		
		Output output = new Output();
		String firstName = output.enterFirstName();
		String lastName = output.enterLastName();
		String status = output.enterStatus();		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setStatus(status);
		return person;
	}

}
