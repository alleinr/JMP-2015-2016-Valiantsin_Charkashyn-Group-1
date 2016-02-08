package com.epam.jmp.threads02.menu;

import com.epam.jmp.threads02.model.Clients;
import com.epam.jmp.threads02.model.ExchangeRate;
import com.epam.jmp.threads02.model.ExchangeRates;
import com.epam.jmp.threads02.model.Person;
import com.epam.jmp.threads02.tool.ClientThreadUploader;
import com.epam.jmp.threads02.tool.DataThreadLoader;
import com.epam.jmp.threads02.tool.ExchangeRateThreadUploader;
import com.epam.jmp.threads02.tool.ThreadPool;
import com.epam.jmp.threads02.tool.datahandler.ClientHandler;
import com.epam.jmp.threads02.tool.datahandler.CurrencyHandler;
import com.epam.jmp.threads02.tool.datahandler.ExchangeRatesHandler;

public class ChoiceHandler {

	public static void handleTheChoice(String stringChoice) {
		int choice = 0;
		try{
			choice = Integer.parseInt(stringChoice);
		} catch (Exception e){
			throw new IllegalArgumentException("Wrong choice format!");
		}
		System.out.println("Choice = " + choice);
		ThreadPool pool = ThreadPool.getInstance();
		switch (choice) {
		case 1:
			pool.addThread(new DataThreadLoader());
			break;
		case 2:
			ExchangeRatesHandler eHandler = new ExchangeRatesHandler();
			ExchangeRate rate = eHandler.createRate();
			ExchangeRates.getInstance().getExchangeRates().add(rate);
			ExchangeRateThreadUploader aUp = new ExchangeRateThreadUploader(ExchangeRates.getInstance());
			pool.addThread(aUp);
			break;
		case 3:
			ClientHandler cHandler = new ClientHandler();
			Person person = cHandler.createClient();
			Clients.getInstance().getClients().add(person);
			ClientThreadUploader cUp = new ClientThreadUploader(Clients.getInstance());
			pool.addThread(cUp);
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
