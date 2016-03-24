package com.epam.task01.rest.dao;

import java.util.List;

import com.epam.task01.rest.model.User;

public interface IUserDAO {
	
	User createUser(User User);
	User getUser(String id);	
	User updateUser(User User);	
	boolean removeUser(String id);	
	List<User> getAll();	
	
}
