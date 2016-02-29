package com.epam.testapp.database;

import java.util.List;
import com.epam.testapp.exception.DAOException;
import com.epam.testapp.model.News;

/**
 * This class consists exclusively of signatures of methods that will be
 * realized in implementation of this interface.
 * <p>
 * The methods of this class all throw a <tt>DAOException</tt> if happens some
 * SQL exception.
 * 
 * @author Anastasiya Kulesh
 * @since 1.0
 */

public interface INewsDAO {

	/**
	 * Fetches an item from database by id.
	 * 
	 * @param id
	 *            unique identification number of item that should be found.
	 * @return found item
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public News fetchById(Integer id) throws DAOException;

	/**
	 * Removes an item from database by id.
	 * 
	 * @param items
	 *            arrays of unique identification numbers of items that should
	 *            be removed.
	 * @return true if removing was finished successfully and false if not.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public void remove(Integer[] items) throws DAOException;

	/**
	 * Creates new item in database by provided News object.
	 * 
	 * @param news
	 *            that should be added to database.
	 * @return unique identification number of item that was created.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public Integer insert(News news) throws DAOException;

	/**
	 * Updates already existing item in	database by provided News object.
	 * 
	 * @param news that should be updated with.
	 * @return unique identification number of item that was updated.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public Integer update(News news) throws DAOException;

	/**
	 * Gets all existing items from database.
	 * 
	 * @return list of items that was loaded from database.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public List<News> getList() throws DAOException;

}
