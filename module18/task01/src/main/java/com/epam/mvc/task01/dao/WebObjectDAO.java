package com.epam.mvc.task01.dao;

import java.util.List;

import com.epam.mvc.task01.services.model.WebObject;

public interface WebObjectDAO {

	public WebObject create(WebObject webObject);
	public WebObject getById(String id);
	public List<WebObject> getAll();
	public WebObject update(WebObject webObject);
	public void remove(String id);
}
