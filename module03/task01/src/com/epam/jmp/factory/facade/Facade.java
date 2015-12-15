package com.epam.jmp.factory.facade;

import com.epam.jmp.factory.factorymethod.AbstractDataHandler;
import com.epam.jmp.factory.factorymethod.FactoryMethod;
import com.epam.jmp.factory.model.Person;

import tool.ConsoleTool;

public class Facade {
	
	public void doTheThing(){
		ConsoleTool consoleTool = new ConsoleTool();
		
		System.out.println("Default loader - db, for file loading press f...");
		String source = consoleTool.takeInput();		
		AbstractDataHandler dataHandler = new FactoryMethod().getHandler(source);
		
		System.out.println("What do you want to do? A - read all entries (default), W - create new entry, R - read entry by name");
		String action = consoleTool.takeInput();
		
		Person person = null;
		if (action.toUpperCase().equals("R")){
			System.out.println("Enter name of the person: ");
			String name = consoleTool.takeInput();
			person = dataHandler.readPerson(name);
			System.out.println(person.toString());
			
		} else if (action.toUpperCase().equals("W")){
				System.out.println("Enter name of the person: ");
				String name = consoleTool.takeInput();
				person = new Person();
				person.setName(name);
				dataHandler.writePerson(person);
				
			} else {
				person = dataHandler.readPerson();
				System.out.println(person.toString());
			}				
	}
}
