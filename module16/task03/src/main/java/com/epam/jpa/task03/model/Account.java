package com.epam.jpa.task03.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	private String id;
	private Currency currency;
	private Person person;
	private int amount;

	public Account(String id, Currency currency, Person owner, int amount) {
		super();
		this.id = id;
		this.currency = currency;
		this.person = owner;
		this.amount = amount;
	}
	
	public Account(){
		
	}
	
	@Id
	@GeneratedValue
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="EXCHANGERATE")
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "CURRENCYID")
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "personId", nullable = false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person owner) {
		this.person = owner;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", currency=" + currency + ", owner="
				+ person + ", amount=" + amount + "]";
	}
	

}
