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

	public int save(WebObject webObject) {
		System.out.println(woDAO);
		int id = webObject.getId();
		if (id == 0) {
			System.out.println("create");
			webObject = woDAO.create(webObject);
		} else {
			System.out.println("update");
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
