package com.epam.jpa.task03.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
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
	
	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EXCHANGERATE")
	public int getExchRate() {
		return exchRate;
	}
	public void setExchRate(int exchRate) {
		this.exchRate = exchRate;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", exchRate=" + exchRate + "]";
	}	
	
	
}
