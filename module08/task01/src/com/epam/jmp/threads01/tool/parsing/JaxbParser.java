package com.epam.jmp.threads01.tool.parsing;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbParser implements Parser {

	@Override
	public Object getObject(File file, Class c) {
		JAXBContext context;
		Object object = null;
		try {
			context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			object = unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return object;
	}

	@Override
	public void saveObject(File file, Object o) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(o.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(o, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
