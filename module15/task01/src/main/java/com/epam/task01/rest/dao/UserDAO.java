package com.epam.task01.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.task01.rest.connection.ConnectionPool;
import com.epam.task01.rest.model.User;

public class UserDAO implements IUserDAO {
	
	public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    public static final String SQL_CREATE_NEW_USER = "INSERT INTO users (id,firstName,lastName,email,login) VALUES (?,?,?,?,?)" ;
    public static final String SQL_UPDATE_USER = "UPDATE users firstName = ?, lastName = ?, email = ?, login = ? WHERE id = ?";
    
    protected static ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(Connection connection){
        connectionPool.closeConnection(connection);
    }

    public static void destroyPool(){
        connectionPool.destroy();
    }
    

	public User createUser(User user) {
		Connection connection = null;
        PreparedStatement st = null;
        try{
            connection = connectionPool.getConnection();
            st = connection.prepareStatement(SQL_CREATE_NEW_USER);
            st.setString(1, user.getId());
			st.setString(2, user.getLastName());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLogin());
			st.setString(5, user.getEmail());			
            st.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }  finally {
            this.closeStatement(st);
            this.closeConnection(connection);
        }
        return user;
	}

	public User getUser(String id) {
		Connection connection = null;
		PreparedStatement st = null;
		User user = null;
		try {
			connection = connectionPool.getConnection();
			st = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email"), rs.getString("login"));
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			this.closeStatement(st);
			this.closeConnection(connection);
		}
		return user;
	}

	public User updateUser(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			connection = connectionPool.getConnection();
			st = connection.prepareStatement(SQL_UPDATE_USER);
			st.setString(1, user.getId());
			st.setString(2, user.getLastName());
			st.setString(3, user.getFirstName());
			st.setString(4, user.getLogin());
			st.setString(5, user.getEmail());			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email"), rs.getString("login"));
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			this.closeStatement(st);
			this.closeConnection(connection);
		}
		return user;
	}

	public boolean removeUser(String id) {
		 Connection connection = null;
	        PreparedStatement st = null;
	        boolean result = false;

	        try{
	            connection = connectionPool.getConnection();
	            st = connection.prepareStatement(SQL_DELETE_USER_BY_ID);
	            st.setString(1, id);
	            st.executeUpdate();
	            result = true;
	        } catch(SQLException e){
	            e.printStackTrace();
	        }  finally {
	            this.closeStatement(st);
	            this.closeConnection(connection);
	        }
	        return result;
	}

	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
        PreparedStatement st = null;
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
            st = connection.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email"), rs.getString("login"));
                userList.add(user);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }  finally {
            this.closeStatement(st);
            this.closeConnection(connection);
        }

        return userList;
	}

}
