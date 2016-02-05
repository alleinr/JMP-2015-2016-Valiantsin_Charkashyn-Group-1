package com.epam.jmp.threads01.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "account")
@XmlType(propOrder = { "id", "curId", "ownerId", "amount" })
public class Account {

	private int id;
	private String curId;
	private int ownerId;
	private int amount;

	public Account(int id, String curId, int ownerId, int amount) {
		super();
		this.id = id;
		this.curId = curId;
		this.ownerId = ownerId;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getCurId() {
		return curId;
	}

	@XmlElement
	public void setCurId(String curId) {
		this.curId = curId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	@XmlElement
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
