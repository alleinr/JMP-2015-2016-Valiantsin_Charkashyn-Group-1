package com.epam.jmp.threads01.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Account> accounts;
	private List<Person> clients;
	private List<Currency> currencies;
	
	public Bank(){
		accounts = new ArrayList<>();
		clients = new ArrayList<>();
		currencies = new ArrayList<>();
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public List<Person> getClients() {
		return clients;
	}
	public void setClients(List<Person> clients) {
		this.clients = clients;
	}
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
}
