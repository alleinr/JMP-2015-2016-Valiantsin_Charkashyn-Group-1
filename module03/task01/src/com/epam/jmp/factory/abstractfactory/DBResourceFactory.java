package com.epam.jmp.factory.abstractfactory;

import com.epam.jmp.factory.model.DBResource;
import com.epam.jmp.factory.model.Resource;

public class DBResourceFactory extends ResourceFactory{

	@Override
	public Resource createResource() {		
		return new DBResource();
	}

}
