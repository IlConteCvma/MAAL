package logic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnectionDB {
	
	private static SingletonConnectionDB instance = null;
	private static int count = 0;
	private static Connection conn;
	
	
	
	protected SingletonConnectionDB() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/maaldb", "root", "");
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
	
	public synchronized static SingletonConnectionDB getSingletonConnection() {
		count++;
		try {
			if (SingletonConnectionDB.instance == null)
				SingletonConnectionDB.instance = new SingletonConnectionDB();
		}catch (SQLException se) {
            se.printStackTrace();
        }catch (ClassNotFoundException se2) {
        	se2.printStackTrace();
        }
		return instance;
	}
	
	public synchronized static void close() {
		if(SingletonConnectionDB.count==0) {
			try {
				SingletonConnectionDB.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}