package com.epam.jmp.threads01.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "currency")
@XmlType(propOrder = {"id","name","exchRate"})
public class Currency {
	
	private String id;
	private String name;
	private int exchRate;
	
	public Currency(String id, String name, int exchRate) {		
		this.id = id;
		this.name = name;
		this.exchRate = exchRate;
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
	public int getExchRate() {
		return exchRate;
	}
	@XmlElement
	public void setExchRate(int exchRate) {
		this.exchRate = exchRate;
	}	
}
