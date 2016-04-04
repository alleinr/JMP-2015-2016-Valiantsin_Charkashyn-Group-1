package com.epam.jpa.task03.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task03.model.Account;

@Component("accountDAO")
public class AccountDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Account fetchById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Account account = (Account) session.get(Account.class, id);
		tx.commit();
		return account;
	}

	public void remove(Integer[] items) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Account n where n.id in (:ids)");
		query.setParameterList("ids", items);
		query.executeUpdate();
		tx.commit();
	}

	public String insert(Account account) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(account);
		tx.commit();
		return account.getId();
	}

	public String update(Account account) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(account);
		tx.commit();
		return account.getId();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Account> getList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Account> allAccounts = session.createCriteria(Account.class).list();
		tx.commit();
		return allAccounts;
	}
}
