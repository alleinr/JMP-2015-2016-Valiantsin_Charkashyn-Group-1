package com.epam.jpa.task02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task02.dao.ClientDAO;
import com.epam.jpa.task02.model.Client;

@Component
public class ClientService {

	@Autowired
	ClientDAO dao;

	@Transactional
	public Client create(Client client) {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		client = dao.create(client);
		return client;
	}

	@Transactional
	public void delete(Client client) {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
			if (client != null) {
				dao.delete(client.getId());
			}

	}

	@Transactional
	public Client searchPerson(String id) {
		if (dao == null || id == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		Client client = null;
		client = dao.get(id);
		return client;

	}

	@Transactional
	public List<Client> getAll() {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		List<Client> clientList = null;
		clientList = dao.getAll();
		return clientList;
	}
}
