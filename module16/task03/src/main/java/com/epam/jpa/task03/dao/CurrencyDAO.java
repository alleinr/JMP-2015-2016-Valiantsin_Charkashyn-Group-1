package com.epam.jpa.task03.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task03.model.Currency;

@Component("currencyDAO")
public class CurrencyDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Currency fetchById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Currency currency = (Currency) session.get(Currency.class, id);
		tx.commit();
		return currency;
	}

	public void remove(Integer[] items) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Account n where n.id in (:ids)");
		query.setParameterList("ids", items);
		query.executeUpdate();
		tx.commit();
	}

	public String insert(Currency currency) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(currency);
		tx.commit();
		return currency.getId();
	}

	public String update(Currency currency) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(currency);
		tx.commit();
		return currency.getId();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Currency> getList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Currency> allCurrencies = session.createCriteria(Currency.class).list();
		tx.commit();
		return allCurrencies;
	}
}
