package com.epam.jpa.task02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task02.dao.ClientDAO;
import com.epam.jpa.task02.model.Client;

@Component("clientService")
public class ClientService {

	@Autowired
	@Qualifier("clientDAO")
	private ClientDAO clientDao;	

	public ClientDAO getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDAO clientDao) {
		this.clientDao = clientDao;
	}

	@Transactional
	public Client create(Client client) {
		client = clientDao.create(client);
		return client;
	}

	@Transactional
	public void delete(Client client) {
			if (client != null) {
				clientDao.delete(client.getId());
			}

	}

	@Transactional
	public Client searchPerson(String id) {
		Client client = null;
		client = clientDao.get(id);
		return client;

	}

	@Transactional
	public List<Client> getAll() {
		List<Client> clientList = null;
		clientList = clientDao.getAll();
		return clientList;
	}
}
