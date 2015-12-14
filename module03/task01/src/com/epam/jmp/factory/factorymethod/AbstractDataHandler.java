package com.epam.jmp.factory.factorymethod;

import com.epam.jmp.factory.model.Person;

public abstract class AbstractDataHandler {
	 abstract void writePerson (Person person);
	 abstract Person readPerson();
	 abstract Person readPerson (String name);
}
