package com.epam.jmp.threads02.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rates")
public class ExchangeRates {
	
	private List<ExchangeRate> exchangeRates;
	
	@XmlElement(name = "rate")
	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}
	
	@Override
	public String toString() {
		return "Accounts [accounts=" + exchangeRates + "]";
	}

	
	
	
	
}
