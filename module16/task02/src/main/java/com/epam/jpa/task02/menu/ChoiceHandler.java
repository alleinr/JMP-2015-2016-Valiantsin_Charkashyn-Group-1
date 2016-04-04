package com.epam.jpa.task02.menu;

import java.util.List;

import com.epam.jpa.task02.model.Account;
import com.epam.jpa.task02.model.Client;
import com.epam.jpa.task02.service.AccountService;
import com.epam.jpa.task02.service.ClientService;

public class ChoiceHandler {

	public static void handleTheChoice(String stringChoice, AccountService accounts, ClientService clients) {
		int choice = Integer.parseInt(stringChoice);

		switch (choice) {
		case 1:
			// load clients
			List<Client> clientList = clients.getAll();
			for (Client client: clientList){
				System.out.println(client);
			}
			break;
		case 2:
			//load accounts
			List<Account> accountList = accounts.getAll();
			for (Account account: accountList){
				System.out.println(account);
			}
			break;
		case 3:
			// exit
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice...");
			break;
		}
	}
}
