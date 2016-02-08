package com.epam.jmp.threads01.tool.datahandler;

import com.epam.jmp.threads01.menu.Output;
import com.epam.jmp.threads01.model.Bank;
import com.epam.jmp.threads01.model.Currencies;
import com.epam.jmp.threads01.model.Currency;

public class CurrencyHandler {

	public int exchange(){
		
		Output output = new Output();
		String currency = output.enterCurrency();
		int amount = new Integer(output.enterAmount());		
		Currencies currencies = Bank.getInstance().getCurrencies();
		int exchRate = 0;
		for (Currency curr :currencies.getCurrencies()){
			if (curr.getId() == currency){
				exchRate = curr.getExchRate();
			}
		}		
		return exchRate*amount;
		
	}
}
