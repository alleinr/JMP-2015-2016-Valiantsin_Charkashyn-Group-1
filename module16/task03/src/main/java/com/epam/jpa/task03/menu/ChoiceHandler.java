package com.epam.jpa.task03.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.jpa.task03.dao.AccountDAO;
import com.epam.jpa.task03.dao.CurrencyDAO;
import com.epam.jpa.task03.dao.PersonDAO;
import com.epam.jpa.task03.model.Account;
import com.epam.jpa.task03.model.Person;
import com.epam.jpa.task03.tool.datahandler.AccountHandler;
import com.epam.jpa.task03.tool.datahandler.CurrencyHandler;
import com.epam.jpa.task03.tool.datahandler.PersonHandler;

@Component("handler")
public class ChoiceHandler {
	
	@Autowired
	private CurrencyDAO currencyDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private PersonDAO personDAO;

	public CurrencyDAO getCurrencyDAO() {
		return currencyDAO;
	}

	public void setCurrencyDAO(CurrencyDAO currencyDAO) {
		this.currencyDAO = currencyDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public void handleTheChoice(String stringChoice) {
		int choice = Integer.parseInt(stringChoice);
		System.out.println("Choice = " + choice);
		switch (choice) {
		case 1:
			AccountHandler aHandler = new AccountHandler();
			Account account = aHandler.createAccount();
			accountDAO.insert(account);
			break;
		case 2:
			PersonHandler cHandler = new PersonHandler();
			Person person = cHandler.createClient();
			personDAO.insert(person);
			break;
		case 3:
			CurrencyHandler curHandler = new CurrencyHandler();
			int amount = curHandler.exchange();
			System.out.println("Amount to give to client = " + amount);
			break;
		default:
			// System.exit(0);
			break;
		}
	}
}
