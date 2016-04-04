package com.epam.jpa.task01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task01.dao.UnitDAO;
import com.epam.jpa.task01.model.Unit;

@Component("unitService")
@Transactional
public class UnitService {

	@Autowired
	private UnitDAO dao;

	public UnitDAO getDao() {
		return dao;
	}

	public void setDao(UnitDAO dao) {
		this.dao = dao;
	}

	public Unit create(Unit account) {
		account = dao.create(account);
		return account;
	}

	public void delete(Unit account) {
		if (account != null) {
			dao.delete(account.getId());
		}

	}

	public Unit getUnit(String id) {
		Unit account = null;
		account = dao.get(id);
		return account;

	}

	public List<Unit> getAll() {
		List<Unit> accountList = null;
		accountList = dao.getAll();
		return accountList;
	}
}
