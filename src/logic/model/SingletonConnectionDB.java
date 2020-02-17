package logic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnectionDB {

	private static SingletonConnectionDB instance = null;
	private static int count = 0;
	private static Connection conn;

	protected SingletonConnectionDB() throws SQLException {
		connect();
	}

	private static void connect() throws SQLException {

		conn = DriverManager.getConnection("jdbc:mysql://localhost/maaldb", "root", "toor");

	}

	public static void closeConnection(Connection conn) throws SQLException {

		conn.close();

	}

	public static void increaseCount() {
		SingletonConnectionDB.count++;
	}

	public static void decreaseCount() {
		SingletonConnectionDB.count--;
	}

	public Connection getConnection() {
		return conn;
	}

	public static synchronized SingletonConnectionDB getSingletonConnection() throws SQLException {
		count++;

		if (SingletonConnectionDB.instance == null)
			SingletonConnectionDB.instance = new SingletonConnectionDB();
		return instance;
	}

	public static synchronized void close() throws SQLException {
		if (SingletonConnectionDB.count == 0) {

			SingletonConnectionDB.conn.close();

		}
	}

}