package com.epam.mvc.task01.services.service;

import java.util.List;

import com.epam.mvc.task01.dao.WebObjectDAO;
import com.epam.mvc.task01.services.model.WebObject;

public class WebObjectServiceImpl implements WebObjectService {

	private WebObjectDAO woDAO;

	public void setWoDAO(WebObjectDAO woDAO) {
		this.woDAO = woDAO;
	}

	public WebObjectDAO getWoDAO() {
		return woDAO;
	}

	public String save(WebObject webObject) {
		String id = webObject.getId();
		if (id == null) {
			webObject = woDAO.create(webObject);
		} else {
			webObject = woDAO.update(webObject);
		}
		return webObject.getId();
	}

	public List<WebObject> getList() {
		List<WebObject> allObjects;
		allObjects = woDAO.getAll();
		return allObjects;
	}

	public WebObject fetchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(String id) {
		// TODO Auto-generated method stub

	}
}
