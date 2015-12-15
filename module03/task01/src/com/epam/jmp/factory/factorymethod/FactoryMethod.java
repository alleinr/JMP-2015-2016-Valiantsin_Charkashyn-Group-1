package com.epam.jmp.factory.factorymethod;

import com.epam.jmp.factory.abstractfactory.DBResourceFactory;
import com.epam.jmp.factory.abstractfactory.FileResourceFactory;
import com.epam.jmp.factory.abstractfactory.ResourceFactory;
import com.epam.jmp.factory.model.Resource;

public class FactoryMethod {
	public AbstractDataHandler getHandler(Object object) {

		AbstractDataHandler handler = null;
		ResourceFactory factory = null;
		
		if (object.equals("f")) {
			handler = new FileDataHandler();
			factory = new FileResourceFactory();
		} else {
			handler = new DBDataHandler();
			factory = new DBResourceFactory();			
		}
		
		Resource resource = factory.createResource();
		handler.setResource(resource);
		return handler;
	}
}
