package com.epam.jpa.task03.tool.datahandler;

import com.epam.jpa.task03.menu.Output;
import com.epam.jpa.task03.model.Bank;
import com.epam.jpa.task03.model.Currency;

public class CurrencyHandler {

	public int exchange(){
		
		Output output = new Output();
		String currency = output.enterCurrency();
		int amount = new Integer(output.enterAmount());			
		int exchRate = 0;
		for (Currency curr : Bank.getInstance().getCurrencies()){
			if (curr.getId() == currency){
				exchRate = curr.getExchRate();
			}
		}		
		return exchRate*amount;
		
	}
}
