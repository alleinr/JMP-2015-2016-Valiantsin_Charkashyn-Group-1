package com.epam.jmp.threads02.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rates")
public class ExchangeRates {
	
	private List<ExchangeRate> exchangeRatesList;
	
	private static ExchangeRates exchangeRates;
	private ExchangeRates() {		
	}
	
	public static ExchangeRates getInstance(){
		if (exchangeRates == null){
			synchronized (ExchangeRates.class){
				if (exchangeRates == null){
					exchangeRates = new ExchangeRates();
				}
			}
		}
		return exchangeRates;
	}
	
	@XmlElement(name = "rate")
	public List<ExchangeRate> getExchangeRates() {
		return exchangeRatesList;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRatesList = exchangeRates;
	}
	
	@Override
	public String toString() {
		return "Accounts [accounts=" + exchangeRatesList + "]";
	}	
	
}
