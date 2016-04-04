package com.epam.jpa.task02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task02.dao.AccountDAO;
import com.epam.jpa.task02.model.Account;

@Transactional
@Component("accountService")
public class AccountService {
	
	@Autowired
	@Qualifier("accountDAO")
	private AccountDAO accountDao;	
	
	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	public Account create(Account account) {
		account = accountDao.create(account);
		return account;
	}

	public void delete(Account account) {
			if (account != null) {
				accountDao.delete(account.getId());
			}

	}

	public Account getAccount(String id) {
		Account account = null;
		account = accountDao.get(id);
		return account;

	}

	public List<Account> getAll() {
		List<Account> accountList = null;
		accountList = accountDao.getAll();
		return accountList;
	}
}
