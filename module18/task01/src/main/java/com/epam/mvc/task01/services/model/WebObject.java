package com.epam.mvc.task01.services.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEBOBJECT")
@Access(AccessType.FIELD)
public class WebObject {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "STUFF")
	private String stuff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuff() {
		return stuff;
	}

	public void setStuff(String stuff) {
		this.stuff = stuff;
	}

	public WebObject(int id, String name, String stuff) {
		this.id = id;
		this.name = name;
		this.stuff = stuff;
	}

	public WebObject() {
	}

	@Override
	public String toString() {
		return "WebObject [id=" + id + ", name=" + name + ", stuff=" + stuff + "]";
	}

}
