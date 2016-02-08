package com.epam.jmp.threads02.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.jmp.threads02.model.Currencies;
import com.epam.jmp.threads02.model.Currency;

public class CurrencyDAO  implements DAO {

	@Override
	public List<Currency> getAll() {
		JAXBContext context;
		Currencies currencies = null;
		try {
			context = JAXBContext.newInstance(Currencies.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			currencies = (Currencies) unmarshaller.unmarshal(new File("src/resources/currencies.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return currencies.getCurrencies();		
	}

}
