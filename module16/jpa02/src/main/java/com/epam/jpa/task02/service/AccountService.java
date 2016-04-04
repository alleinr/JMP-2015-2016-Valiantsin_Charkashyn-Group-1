package com.epam.jpa.task02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task02.dao.AccountDAO;
import com.epam.jpa.task02.model.Account;

@Component
public class AccountService {
	@Autowired
	AccountDAO dao;

	@Transactional
	public Account create(Account account) {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		account = dao.create(account);
		return account;
	}

	@Transactional
	public void delete(Account account) {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
			if (account != null) {
				dao.delete(account.getId());
			}

	}

	@Transactional
	public Account getAccount(String id) {
		if (dao == null || id == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		Account account = null;
		account = dao.get(id);
		return account;

	}

	@Transactional
	public List<Account> getAll() {
		if (dao == null) {
			throw new IllegalArgumentException("dao wasn't initialized!");
		}
		List<Account> accountList = null;
		accountList = dao.getAll();
		return accountList;
	}
}
