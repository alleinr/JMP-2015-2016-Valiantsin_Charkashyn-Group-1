package com.epam.jmp.threads01.tool.datahandler;

import com.epam.jmp.threads01.menu.Output;
import com.epam.jmp.threads01.model.Account;
import com.epam.jmp.threads01.model.Bank;

public class AccountHandler {
	
public Account createAccount(){
		
		Output output = new Output();
		String id = output.enterId();
		String curId = output.enterCurrency();
		String ownerId = output.enterOwner();
		Integer amount = new Integer(output.enterAmount());		
		Account account = new Account(id, curId, ownerId, amount);		
		return account;
	}
}
