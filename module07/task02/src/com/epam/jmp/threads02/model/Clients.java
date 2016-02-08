package com.epam.jmp.threads02.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clients")
public class Clients {
	private List<Person> clients;
	
	@XmlElement(name = "person")
	public List<Person> getClients() {
		return clients;
	}
	public void setClients(List<Person> clients) {
		this.clients = clients;
	}
	
	@Override
	public String toString() {
		return "Clients [clients=" + clients + "]";
	}
	
	
}
