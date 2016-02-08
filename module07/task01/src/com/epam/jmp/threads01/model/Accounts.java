package com.epam.jmp.threads01.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accounts")
public class Accounts {
	
	private List<Account> accounts;
	
	@XmlElement(name = "account")
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Accounts [accounts=" + accounts + "]";
	}
	
	
	
}
