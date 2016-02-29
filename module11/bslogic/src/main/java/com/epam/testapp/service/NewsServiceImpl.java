package com.epam.testapp.service;

import java.util.List;

import com.epam.testapp.database.INewsDAO;
import com.epam.testapp.exception.DAOException;
import com.epam.testapp.exception.NewsServiceException;
import com.epam.testapp.model.News;

/**
 * This class provides interaction with dao layer and validates data.
 * 
 * @author Anastasiya_Kulesh
 *
 */
public class NewsServiceImpl implements INewsService {

	private INewsDAO newsDAO;

	public void setNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	public INewsDAO getNewsDAO() {
		return newsDAO;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws NewsServiceException
	 */
	public News fetchById(int id) throws NewsServiceException {
		News news;
		try {
			news = newsDAO.fetchById(id);
			if (news == null) {
				throw new NewsServiceException("NULL ERROR");
			}
		} catch (DAOException e) {
			throw new NewsServiceException(e);
		}
		return news;
	}

	/**
	 * 
	 * @param news
	 * @return
	 * @throws NewsServiceException
	 */
	public int save(News news) throws NewsServiceException {
		Integer id = news.getId();
		try {
			if (id == null) {
				id = newsDAO.insert(news);
			} else {
				id = newsDAO.update(news);
			}
			if (id == 0) {
				throw new NewsServiceException("NULL ERROR");
			}
		} catch (DAOException e) {
			throw new NewsServiceException(e);
		}
		return id;
	}

	/**
	 * 
	 * @return
	 * @throws NewsServiceException
	 */
	public List<News> getList() throws NewsServiceException {
		List<News> allNews;
		try {
			allNews = newsDAO.getList();
		} catch (DAOException e) {
			throw new NewsServiceException(e);
		}

		return allNews;
	}

	/**
	 * 
	 * @param items
	 * @throws DAOException
	 */
	public void remove(Integer[] items) throws NewsServiceException {
		try {
			newsDAO.remove(items);
		} catch (DAOException e) {
			throw new NewsServiceException(e);
		}
	}
}
