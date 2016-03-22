package com.epam.task01.rest.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alleinr on 26.06.2014.
 */

public final class ConnectionPool {

	private static final String DB_FILE_NAME = "resources.database";

	private static BlockingQueue<Connection> freeConnections;
	private List<Connection> allConnections = new LinkedList<Connection>();

	private static final Lock LOCK = new ReentrantLock();
	private static ConnectionPool instance = null;

	public static ConnectionPool getInstance() {
		ConnectionPool localInstance = instance;
		if (localInstance == null) {
			LOCK.lock();
			localInstance = instance;
			if (localInstance == null) {
				instance = localInstance = new ConnectionPool();
			}
			LOCK.unlock();
		}
		return localInstance;
	}

	private ConnectionPool() {

		ResourceBundle resource = ResourceBundle.getBundle(DB_FILE_NAME);

		String driverClass = resource.getString("driver");
		int poolSize = Integer.parseInt(resource.getString("poolsize"));
		String url = resource.getString("url");
		String user = resource.getString("user");
		String password = resource.getString("password");

		try {

			Class.forName(driverClass);
			freeConnections = new ArrayBlockingQueue<Connection>(poolSize);
			for (int i = 0; i < poolSize; i++) {
				createConnection(url, user, password);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
			// throw new RuntimeException(e);
		}

	}

	private void createConnection(String url, String user, String password) {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);

			freeConnections.add(connection);
			allConnections.add(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		try {
			return freeConnections.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void closeConnection(Connection connection) {
		try {
			if (!connection.isClosed()) {
				freeConnections.add(connection);
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException at connection isClosed () checking. Connection not closed.", e);
		}
	}

	public void destroy() {
		for (Connection connection : allConnections) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException("Some problem with ConnectionPool.destroy:", e);
			}
		}
		freeConnections.removeAll(freeConnections);
	}
}
