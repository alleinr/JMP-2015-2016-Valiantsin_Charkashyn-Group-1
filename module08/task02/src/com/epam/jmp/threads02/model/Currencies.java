package com.epam.jmp.threads02.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currencies")
public class Currencies {

	private List<Currency> currenciesList;
	
	private static Currencies currencies;
	private Currencies() {		
	}
	
	public static Currencies getInstance(){
		if (currencies == null){
			synchronized (Currencies.class){
				if (currencies == null){
					currencies = new Currencies();
				}
			}
		}
		return currencies;
	}
	
	@XmlElement(name = "currency")
	public List<Currency> getCurrencies() {
		return currenciesList;
	}
	public void setCurrencies(List<Currency> currenciesList) {
		this.currenciesList = currenciesList;
	}
	
	@Override
	public String toString() {
		return "Currencies [currencies=" + currenciesList + "]";
	}
	
	
	
}
