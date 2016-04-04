package com.epam.jpa.task01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.epam.jpa.task01.model.Unit;

@Component
public class UnitDAO {
	
	public EntityManager em = Persistence.createEntityManagerFactory(
			"dbconnect").createEntityManager();

	public Unit create(Unit unit) {
		em.getTransaction().begin();
		unit = em.merge(unit);
		em.getTransaction().commit();
		return unit;
	}

	public void delete(String id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}

	public Unit get(String id) {
		return em.find(Unit.class, id);
	}

	public void update(Unit unit) {
		em.getTransaction().begin();
		em.merge(unit);
		em.getTransaction().commit();
	}

	public List<Unit> getAll() {
		TypedQuery<Unit> namedQuery = em.createNamedQuery("unit.getAll",
				Unit.class);
		return namedQuery.getResultList();
	}
}
