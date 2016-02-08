package com.epam.jmp.threads02.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.jmp.threads02.model.Clients;
import com.epam.jmp.threads02.model.Currencies;
import com.epam.jmp.threads02.model.Person;

public class PersonDAO implements DAO {

	@Override
	public List<Person> getAll() {

		JAXBContext context;
		Clients clients = null;
		try {
			context = JAXBContext.newInstance(Currencies.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			clients = (Clients) unmarshaller.unmarshal(new File("src/resources/clients.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return clients.getClients();

	}

}
