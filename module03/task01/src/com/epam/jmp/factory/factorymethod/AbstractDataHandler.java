package com.epam.jmp.factory.factorymethod;

import com.epam.jmp.factory.model.Person;
import com.epam.jmp.factory.model.Resource;

public abstract class AbstractDataHandler {

	protected Resource resource;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public abstract void writePerson(Person person);

	public abstract Person readPerson();

	public abstract Person readPerson(String name);
}
