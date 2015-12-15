package com.epam.jmp.factory.factorymethod;

import com.epam.jmp.factory.model.Person;
import com.epam.jmp.factory.tool.SerializationTool;

public class FileDataHandler extends AbstractDataHandler {

	@Override
	public void writePerson(Person person) {
		new SerializationTool().serialize(person);		
	}

	@Override
	public Person readPerson() {		
		throw new UnsupportedOperationException();
	}

	@Override
	public Person readPerson(String name) {
		Person person = new SerializationTool().deserialize(name);
		return person;
	}

}
