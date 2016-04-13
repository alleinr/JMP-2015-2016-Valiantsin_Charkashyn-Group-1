package com.epam.mvc.task01.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mvc.task01.services.model.WebObject;

@Qualifier("jpa")
@Transactional
public class WebObjectDAOJPAImpl implements WebObjectDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	public WebObject create(WebObject webObject) {
		entityManager.persist(webObject);
		entityManager.flush();
		return webObject;
	}

	public WebObject getById(String id) {
		return entityManager.find(WebObject.class, id);
	}

	public List<WebObject> getAll() {
		TypedQuery<WebObject> typedQuery = entityManager.createQuery(
				ProjectConstant.JPQL_FIND_ALL_QUERY, WebObject.class);
		return typedQuery.getResultList();
	}

	public WebObject update(WebObject webObject) {
		entityManager.merge(webObject);
		return webObject;
	}

	public void remove(String id) {
		Query query = entityManager.createQuery(ProjectConstant.NQL_REMOVE_QUERY);
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
