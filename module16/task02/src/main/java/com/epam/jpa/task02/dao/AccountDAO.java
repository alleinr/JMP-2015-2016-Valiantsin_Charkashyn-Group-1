package com.epam.jpa.task02.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.epam.jpa.task02.model.Account;

@Component("accountDAO")
public class AccountDAO {
	
	public EntityManager em = Persistence.createEntityManagerFactory(
			"dbconnect").createEntityManager();

	public Account create(Account account) {
		em.getTransaction().begin();
		account = em.merge(account);
		em.getTransaction().commit();
		return account;
	}

	public void delete(String id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}

	public Account get(String id) {
		return em.find(Account.class, id);
	}

	public void update(Account account) {
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
	}

	public List<Account> getAll() {
		TypedQuery<Account> namedQuery = em.createNamedQuery("account.getAll",
				Account.class);
		return namedQuery.getResultList();
	}
}
