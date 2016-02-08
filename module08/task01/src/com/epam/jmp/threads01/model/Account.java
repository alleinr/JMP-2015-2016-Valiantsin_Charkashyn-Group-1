package com.epam.jmp.threads01.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "account")
@XmlType(propOrder = { "id", "curId", "ownerId", "amount" })
public class Account {

	private String id;
	private String curId;
	private String ownerId;
	private int amount;

	public Account(String id, String curId, String ownerId, int amount) {
		super();
		this.id = id;
		this.curId = curId;
		this.ownerId = ownerId;
		this.amount = amount;
	}
	
	public Account(){
		
	}

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getCurId() {
		return curId;
	}

	@XmlElement
	public void setCurId(String curId) {
		this.curId = curId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	@XmlElement
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
		return "Account [id=" + id + ", curId=" + curId + ", ownerId=" + ownerId + ", amount=" + amount + "]";
	}
	
	

}
