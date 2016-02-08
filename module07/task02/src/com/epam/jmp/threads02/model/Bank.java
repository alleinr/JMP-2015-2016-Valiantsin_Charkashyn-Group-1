package com.epam.jmp.threads02.model;

public class Bank {
	
	private static Bank bank;

	private Clients clients;
	private ExchangeRates accounts;
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

	public ExchangeRates getAccounts() {
		return accounts;
	}

	public void setAccounts(ExchangeRates accounts) {
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
