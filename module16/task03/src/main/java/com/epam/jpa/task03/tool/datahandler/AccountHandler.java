package com.epam.jpa.task03.tool.datahandler;

import com.epam.jpa.task03.menu.Output;
import com.epam.jpa.task03.model.Account;
import com.epam.jpa.task03.model.Currency;
import com.epam.jpa.task03.model.Person;

public class AccountHandler {

	public Account createAccount() {

		Output output = new Output();
		String curId = output.enterCurrency();
		Currency currency = new Currency();
		currency.setId(curId);
		String ownerId = output.enterOwner();
		Person owner = new Person();
		owner.setId(ownerId);
		Integer amount = new Integer(output.enterAmount());
		Account account = new Account();
		account.setAmount(amount);
		account.setCurrency(currency);
		account.setPerson(owner);

		return account;
	}
}
