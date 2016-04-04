package com.epam.jpa.task01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task01.dao.PersonalDAO;
import com.epam.jpa.task01.model.Personal;

@Component("personalService")
@Transactional
public class PersonalService {
	
	@Autowired
	private PersonalDAO dao;

	public PersonalDAO getDao() {
		return dao;
	}

	public void setDao(PersonalDAO dao) {
		this.dao = dao;
	}

	public Personal create(Personal account) {
		account = dao.create(account);
		return account;
	}

	public void delete(Personal account) {
		if (account != null) {
			dao.delete(account.getId());
		}

	}

	public Personal getPersonal(String id) {
		Personal account = null;
		account = dao.get(id);
		return account;

	}

	public List<Personal> getAll() {
		List<Personal> accountList = null;
		accountList = dao.getAll();
		return accountList;
	}
}
