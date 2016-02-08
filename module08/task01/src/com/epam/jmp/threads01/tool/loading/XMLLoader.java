package com.epam.jmp.threads01.tool.loading;

import java.io.File;

import com.epam.jmp.threads01.model.Accounts;
import com.epam.jmp.threads01.model.Bank;
import com.epam.jmp.threads01.model.Clients;
import com.epam.jmp.threads01.model.Currencies;
import com.epam.jmp.threads01.tool.parsing.JaxbParser;

public class XMLLoader implements Loader {

	public Bank load() {

		Bank bank = Bank.getInstance();

		synchronized (XMLLoader.class) {
			JaxbParser parser = new JaxbParser();

			File currFile = new File("src/resources/currencies.xml");
			File accFile = new File("src/resources/accounts.xml");
			File persFile = new File("src/resources/clients.xml");
			Currencies currencies = (Currencies) parser.getObject(currFile, Currencies.class);
			Accounts accounts = (Accounts) parser.getObject(accFile, Accounts.class);
			Clients clients = (Clients) parser.getObject(persFile, Clients.class);

			bank.setAccounts(accounts);
			bank.setClients(clients);
			bank.setCurrencies(currencies);

		}
		return bank;
	}
}
