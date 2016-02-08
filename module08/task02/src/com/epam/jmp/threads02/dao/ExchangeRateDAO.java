package com.epam.jmp.threads02.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.epam.jmp.threads02.model.ExchangeRate;
import com.epam.jmp.threads02.model.ExchangeRates;

public class ExchangeRateDAO implements DAO{

	@Override
	public List<ExchangeRate> getAll() {
		JAXBContext context;
		ExchangeRates rates = null;
		try {
			context = JAXBContext.newInstance(ExchangeRates.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			rates = (ExchangeRates) unmarshaller.unmarshal(new File("src/resources/rates.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return rates.getExchangeRates();			
	}
	
	public void saveObject(Object o) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(o.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(o, new File("src/resources/rates.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
