package com.epam.jmp.threads01.model;

public class Bank {
	
	private static Bank bank;

	private Clients clients;
	private Accounts accounts;
	private Currencies currencies;
	
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

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public Currencies getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Currencies currencies) {
		this.currencies = currencies;
	}

	

	@Override
	public String toString() {
		return "Bank: [accounts=" + accounts.toString() + ",\n clients=" + clients.toString() + ",\n currencies="
				+ currencies.toString() + "]";
	}

}
