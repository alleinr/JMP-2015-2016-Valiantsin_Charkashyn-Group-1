package com.epam.jpa.task03.model;

import java.util.List;

public class Bank {
	
	private static Bank bank;

	private List<Person> clients;
	private List<Account> accounts;
	private List<Currency> currencies;
	
	private Bank() {		
	}
	
	public static Bank getInstance(){
		if (bank == null){
			synchronized (Bank.class){
				if (bank == null){
					bank = new Bank();
				}
			}
		}
		return bank;
	}

	public List<Person> getClients() {
		return clients;
	}

	public void setClients(List<Person> clients) {
		this.clients = clients;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}	

	@Override
	public String toString() {
		return "Bank: [accounts=" + accounts.toString() + ",\n clients=" + clients.toString() + ",\n currencies="
				+ currencies.toString() + "]";
	}

}
