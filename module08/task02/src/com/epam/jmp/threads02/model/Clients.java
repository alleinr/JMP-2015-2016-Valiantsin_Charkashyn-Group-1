package com.epam.jmp.threads02.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clients")
public class Clients {
	
	private List<Person> clientList;
	
	private static Clients clients;
	private Clients() {		
	}
	
	public static Clients getInstance(){
		if (clients == null){
			synchronized (Clients.class){
				if (clients == null){
					clients = new Clients();
				}
			}
		}
		return clients;
	}
	
	@XmlElement(name = "person")
	public List<Person> getClients() {
		return clientList;
	}
	public void setClients(List<Person> clients) {
		this.clientList = clients;
	}
	
	@Override
	public String toString() {
		return "Clients [clients=" + clientList + "]";
	}
	
	
}
