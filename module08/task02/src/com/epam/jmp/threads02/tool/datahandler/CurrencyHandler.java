package com.epam.jmp.threads02.tool.datahandler;

import com.epam.jmp.threads02.menu.Output;
import com.epam.jmp.threads02.model.Currencies;
import com.epam.jmp.threads02.model.Currency;

public class CurrencyHandler {

	public int exchange(){
		
		Output output = new Output();
		String currency = output.enterCurrency();
		int amount = new Integer(output.enterAmount());		
		Currencies currencies = Currencies.getInstance();
		int exchRate = 0;
		for (Currency curr :currencies.getCurrencies()){
			if (curr.getId() == currency){
				//exchRate = curr.getExchRate();
			}
		}		
		return exchRate*amount;
		
	}
}
