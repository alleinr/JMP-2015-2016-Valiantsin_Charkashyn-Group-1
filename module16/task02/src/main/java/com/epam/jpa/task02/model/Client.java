package com.epam.jpa.task02.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "client")
@NamedQuery(name = "client.getAll", query = "SELECT c from Client c")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "ACCOUNTSLIST")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	@Cascade({CascadeType.SAVE_UPDATE})
	@PrimaryKeyJoinColumn
	private List<Account> accountLists;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Account> getAccountLists() {
		return accountLists;
	}
	public void setAccountLists(List<Account> accountLists) {
		this.accountLists = accountLists;
	}
	
	
}
