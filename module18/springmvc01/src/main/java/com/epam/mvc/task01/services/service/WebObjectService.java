package com.epam.mvc.task01.services.service;

import java.util.List;

import com.epam.mvc.task01.services.model.WebObject;

public interface WebObjectService {

	public WebObject fetchById(String id);
	public String save(WebObject webObject);
	public List<WebObject> getList();
	public void remove(String id);
}
