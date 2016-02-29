package com.epam.testapp.database;

import com.epam.testapp.exception.DAOException;
import com.epam.testapp.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * This class is a JDBC implementation of interface and consists exclusively of
 * method of said interface.
 * <p>
 * The methods of this class all throw a <tt>DAOException</tt> if happens some
 * SQL error.
 * 
 * @author Anastasiya Kulesh
 * @since 1.0
 */

public class NewsDAOImpl implements INewsDAO {

	public static final String SQL_FIND_ALL_QUERY = "SELECT ID,TITLE,POSTDATE,BRIEF,CONTENT FROM NEWS ORDER BY POSTDATE DESC";
	public static final String SQL_FIND_BY_ID_QUERY = "SELECT ID,TITLE,POSTDATE,BRIEF,CONTENT FROM NEWS WHERE ID = ?";
	public static final String SQL_CREATE_NEWS_QUERY = "INSERT INTO NEWS (TITLE,POSTDATE,BRIEF,CONTENT) VALUES (?,?,?,?)";
	public static final String SQL_DELETE_NEWS_QUERY = "DELETE FROM NEWS WHERE ID = ?";
	public static final String SQL_UPDATE_NEWS_QUERY = "UPDATE NEWS SET TITLE = ?, POSTDATE = ?, BRIEF = ?, CONTENT = ? WHERE ID = ? ";
	public static final String SQL_ID_PARAM = "ID";
	public static final String SQL_TITLE_PARAM = "TITLE";
	public static final String SQL_POSTDATE_PARAM = "POSTDATE";
	public static final String SQL_BRIEF_PARAM = "BRIEF";
	public static final String SQL_CONTENT_PARAM = "CONTENT";

	/**
	 * Field that contains dataSource object.
	 */
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Fetches an item from database by id.
	 * 
	 * @param id
	 *            unique identification number of item that should be found.
	 * @return item that was found item or null if item wasn't found
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	@Override
	public News fetchById(Integer id) throws DAOException {
		News news = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID_QUERY)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				news = new News();
				news.setId(rs.getInt(SQL_ID_PARAM));
				news.setTitle(rs.getString(SQL_TITLE_PARAM));
				news.setBrief(rs.getString(SQL_BRIEF_PARAM));
				news.setPostDate(rs.getDate(SQL_POSTDATE_PARAM));
				news.setContent(rs.getString(SQL_CONTENT_PARAM));
			}

		} catch (SQLException e) {
			throw new DAOException("Error! " + id, e);
		}
		return news;
	}

	/**
	 * Removes an item from database by id.
	 * 
	 * @param news
	 *            that should be updated with.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	@Override
	public void remove(Integer[] items) throws DAOException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_DELETE_NEWS_QUERY)) {
			for (int id : items) {
				ps.setInt(1, id);
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			throw new DAOException("Error! " + items.toString(), e);
		}
	}

	/**
	 * Creates new item in database by provided News object.
	 * 
	 * @param news
	 *            that should be added to database.
	 * @return unique identification number of item that was created.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	@Override
	public Integer insert(News news) throws DAOException {
		Integer id = news.getId();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_CREATE_NEWS_QUERY, new String[] { SQL_ID_PARAM })) {
			ps.setString(1, news.getTitle());
			ps.setDate(2, new java.sql.Date(news.getPostDate().getTime()));
			ps.setString(3, news.getBrief());
			ps.setString(4, news.getContent());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException("Error! ", e);
		}
		return id;
	}

	/**
	 * Updates already existing item in database by provided News object.
	 * 
	 * @param news
	 *            that should be updated with.
	 * @return unique identification number of item that was updated.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	public Integer update(News news) throws DAOException {
		Integer id = 0;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_NEWS_QUERY)) {
			ps.setString(1, news.getTitle());
			ps.setDate(2, new java.sql.Date(news.getPostDate().getTime()));
			ps.setString(3, news.getBrief());
			ps.setString(4, news.getContent());
			ps.setInt(5, news.getId());
			ps.executeUpdate();
			id = news.getId();
		} catch (SQLException e) {
			throw new DAOException("Error! " + news.getId(), e);
		}
		return id;
	}

	/**
	 * Gets all existing items from database.
	 * 
	 * @return list of items that was loaded from database.
	 * @throws DAOException
	 *             if happens some SQL error.
	 */
	@Override
	public List<News> getList() throws DAOException {
		List<News> allNews = new ArrayList<>();
		try (Connection conn = dataSource.getConnection(); Statement ps = conn.createStatement();) {
			ResultSet rs = ps.executeQuery(SQL_FIND_ALL_QUERY);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt(SQL_ID_PARAM));
				news.setTitle(rs.getString(SQL_TITLE_PARAM));
				news.setBrief(rs.getString(SQL_BRIEF_PARAM));
				news.setPostDate(rs.getTimestamp(SQL_POSTDATE_PARAM));
				news.setContent(rs.getString(SQL_CONTENT_PARAM));
				allNews.add(news);
			}
		} catch (SQLException e) {
			throw new DAOException("Error occurred while downloading list ", e);
		}
		return allNews;
	}
}
