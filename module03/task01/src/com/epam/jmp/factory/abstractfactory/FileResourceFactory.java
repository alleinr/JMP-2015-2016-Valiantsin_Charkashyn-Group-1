package com.epam.jmp.factory.abstractfactory;

import com.epam.jmp.factory.model.FileResource;
import com.epam.jmp.factory.model.Resource;

public class FileResourceFactory extends ResourceFactory{

	@Override
	public Resource createResource() {
		return new FileResource();
	}

}
