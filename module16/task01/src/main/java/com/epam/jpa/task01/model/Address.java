package com.epam.jpa.task01.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address {

	@Column(name = "CITY")
	private String city;
	@Column(name = "STREET")
	private String street;
	@Column(name = "HOUSE")
	private String house;
	@Column(name = "APPARTAMENT")
	private String appartement;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
	public String getAppartement() {
		return appartement;
	}

	public void setAppartement(String appartement) {
		this.appartement = appartement;
	}

}
