package com.epam.jmp.threads02.menu;

import java.io.File;

import com.epam.jmp.threads02.model.Account;
import com.epam.jmp.threads02.model.Bank;
import com.epam.jmp.threads02.model.Person;
import com.epam.jmp.threads02.tool.DataThreadLoader;
import com.epam.jmp.threads02.tool.DataThreadUploader;

public class ChoiceHandler {

	public static void handleTheChoice(String stringChoice) {
		int choice = Integer.parseInt(stringChoice);
		DataThreadLoader loader = new DataThreadLoader();
		System.out.println("Choice = " + choice);
		switch (choice) {
		case 1:
			loader.run();
			break;
		case 2:
			AccountHandler aHandler = new AccountHandler();
			ExchangeRate account = aHandler.createAccount();
			File aFile = new File("src/resources/accounts.xml");
			Bank.getInstance().getAccounts().getAccounts().add(account);
			DataThreadUploader aUp = new DataThreadUploader(Bank.getInstance().getAccounts(), aFile);
			aUp.run();			
			loader.run();
			break;
		case 3:
			ClientHandler cHandler = new ClientHandler();
			Person person = cHandler.createClient();
			Bank.getInstance().getClients().getClients().add(person);
			File pFile = new File("src/resources/clients.xml");
			DataThreadUploader pUp = new DataThreadUploader(Bank.getInstance().getClients(), pFile);
			pUp.start();
			loader.run();
			break;
		case 4:
			CurrencyHandler curHandler = new CurrencyHandler();			
			int amount = curHandler.exchange();
			System.out.println("Amount to give to client = " + amount);
			break;
		default:
			//System.exit(0);
			break;
		}
	}
}
