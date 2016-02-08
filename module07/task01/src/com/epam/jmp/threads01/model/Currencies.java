package com.epam.jmp.threads01.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currencies")
public class Currencies {

	private List<Currency> currencies;
	
	@XmlElement(name = "currency")
	public List<Currency> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
	
	@Override
	public String toString() {
		return "Currencies [currencies=" + currencies + "]";
	}
	
	
	
}
