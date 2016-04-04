package com.epam.jpa.task01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.epam.jpa.task01.model.Personal;

@Component
public class PersonalDAO {
	
	public EntityManager em = Persistence.createEntityManagerFactory(
			"dbconnect").createEntityManager();

	public Personal create(Personal personal) {
		em.getTransaction().begin();
		personal = em.merge(personal);
		em.getTransaction().commit();
		return personal;
	}

	public void delete(String id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}

	public Personal get(String id) {
		return em.find(Personal.class, id);
	}

	public void update(Personal personal) {
		em.getTransaction().begin();
		em.merge(personal);
		em.getTransaction().commit();
	}

	public List<Personal> getAll() {
		TypedQuery<Personal> namedQuery = em.createNamedQuery("personal.getAll",
				Personal.class);
		return namedQuery.getResultList();
	}
}
