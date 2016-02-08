package com.epam.jmp.threads02.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "currency")
@XmlType(propOrder = {"id","name", "amount"})
public class Currency {
	
	private String id;
	private String name;
	private int amount;
	
	public Currency(String id, String name, int amount) {		
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public Currency(){
		
	}
	
	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}
	@XmlElement
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + "]";
	}	
	
	
}
