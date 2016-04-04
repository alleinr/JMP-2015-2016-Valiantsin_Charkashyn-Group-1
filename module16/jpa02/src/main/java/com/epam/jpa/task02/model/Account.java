package com.epam.jpa.task02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@NamedQuery(name = "account.getAll", query = "SELECT a from account a")
public class Account {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "ACCOUNTNUMBER")
	private String accountNumber;
	@Column(name = "CURRENCY")
	private String currency;
	@Column(name = "QUANTITY")
	private int quantity;
	private Client client;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OWNERID", nullable = false)
	public Client getClient() {
		return client;
	}

	public void setOwnerId(Client client) {
		this.client = client;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
