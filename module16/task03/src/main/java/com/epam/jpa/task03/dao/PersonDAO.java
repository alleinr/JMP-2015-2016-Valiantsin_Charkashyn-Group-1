package com.epam.jpa.task03.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpa.task03.model.Person;

@Component("personDAO")
public class PersonDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Person fetchById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Person person = (Person) session.get(Person.class, id);
		tx.commit();
		return person;
	}

	public void remove(Integer[] items) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Person n where n.id in (:ids)");
		query.setParameterList("ids", items);
		query.executeUpdate();
		tx.commit();
	}

	public String insert(Person person) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		return person.getId();
	}

	public String update(Person person) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.update(person);
		tx.commit();
		return person.getId();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> getList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Person> allPersons = session.createCriteria(Person.class).list();
		tx.commit();
		return allPersons;
	}

}
