package com.epam.jmp.threads02.tool.datahandler;

import com.epam.jmp.threads02.menu.Output;
import com.epam.jmp.threads02.model.ExchangeRate;

public class ExchangeRatesHandler {
	
public ExchangeRate createRate(){
		
		Output output = new Output();
		String id = output.enterId();
		String currencybuy = output.enterCurrency();
		String currencysell = output.enterCurrency();
		Integer amount = new Integer(output.enterAmount());		
		ExchangeRate rate = new ExchangeRate(id, currencybuy, currencysell, amount);		
		return rate;
	}
}
