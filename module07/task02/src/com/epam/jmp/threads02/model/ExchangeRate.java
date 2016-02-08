package com.epam.jmp.threads02.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rate")
@XmlType(propOrder = { "id", "currencybuy", "currencysell", "rate" })
public class ExchangeRate {

	private String id;
	private String currencybuy;
	private String currencysell;
	private int rate;

	public ExchangeRate() {

	}

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getCurrencybuy() {
		return currencybuy;
	}

	public void setCurrencybuy(String currencybuy) {
		this.currencybuy = currencybuy;
	}

	@XmlElement
	public String getCurrencysell() {
		return currencysell;
	}

	public void setCurrencysell(String currencysell) {
		this.currencysell = currencysell;
	}

	@XmlElement
	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
