package com.epam.testapp.service;

import java.util.List;

import com.epam.testapp.exception.DAOException;
import com.epam.testapp.exception.NewsServiceException;
import com.epam.testapp.model.News;


/**
 * This interface provides interaction methods with dao layer and validates data.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public interface INewsService {

	/**
	 * 
	 * @param id
	 * @return
	 * @throws NewsServiceException
	 */
	public News fetchById(int id) throws NewsServiceException;
	
	/**
	 * 
	 * @param news
	 * @return
	 * @throws NewsServiceException
	 */
	public int save(News news) throws NewsServiceException;
	
	/**
	 * 
	 * @return
	 * @throws NewsServiceException
	 */
	public List<News> getList() throws NewsServiceException;
	
	/**
	 * 
	 * @param items
	 * @throws DAOException
	 */
	public void remove(Integer[] items) throws NewsServiceException;
}
