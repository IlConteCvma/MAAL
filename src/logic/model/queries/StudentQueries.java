package logic.model.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentQueries {
	
	private StudentQueries() {
		 throw new IllegalStateException("Utility class");
	 }

	public static ResultSet selectStudent(Statement stmt, String username, String password) throws SQLException  {
		String sql = "SELECT * FROM studente where Username = '" + username + "'and Password = '"+password+"';";
		return stmt.executeQuery(sql);
	}
	
	public static ResultSet selectSingleStudent(Statement stmt, String username ) throws SQLException{
		String sql = "SELECT * FROM studente where Username = '" + username + "' ;";
		return stmt.executeQuery(sql);
	}
		
}

