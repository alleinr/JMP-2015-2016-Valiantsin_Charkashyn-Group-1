package com.epam.jmp.threads02.tool;

import com.epam.jmp.threads02.dao.CurrencyDAO;
import com.epam.jmp.threads02.dao.DAO;
import com.epam.jmp.threads02.dao.ExchangeRateDAO;
import com.epam.jmp.threads02.dao.PersonDAO;
import com.epam.jmp.threads02.model.Clients;
import com.epam.jmp.threads02.model.Currencies;
import com.epam.jmp.threads02.model.ExchangeRates;

public class DataThreadLoader extends Thread {

	public void run() {	
		
			DAO loader = new PersonDAO();
			Clients clients = Clients.getInstance();
			clients.setClients(loader.getAll());
			
			loader = new CurrencyDAO();
			Currencies currencies = Currencies.getInstance();
			currencies.setCurrencies(loader.getAll());
			
			loader = new ExchangeRateDAO();
			ExchangeRates exchRates = ExchangeRates.getInstance();
			exchRates.setExchangeRates(loader.getAll());			
	}

}
