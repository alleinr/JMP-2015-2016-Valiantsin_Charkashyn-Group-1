package com.epam.mvc.task01.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mvc.task01.services.model.WebObject;

@Transactional
public class WebObjectDAOJPAImpl implements WebObjectDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public WebObject create(WebObject webObject) {
		entityManager.persist(webObject);
		entityManager.flush();
		return webObject;
	}

	public WebObject getById(String id) {
		return entityManager.find(WebObject.class, id);
	}

	public List<WebObject> getAll() {
		TypedQuery<WebObject> typedQuery = entityManager.createQuery("SELECT o FROM WebObject o", WebObject.class);
		return typedQuery.getResultList();
	}

	public WebObject update(WebObject webObject) {
		entityManager.merge(webObject);
		return webObject;
	}

	public void remove(String id) {
		Query query = entityManager.createQuery("DELETE FROM WebObject o WHERE o.id in (:id)");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
