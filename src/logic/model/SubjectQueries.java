package logic.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectQueries {

	public static ResultSet findSubjectOfLesson(Statement stmt, int idLesson) throws SQLException  {
		
		String sql = "SELECT Materia " + 
				"FROM lezione " + 
				"WHERE lezione.ID = "+ idLesson +";";

		return stmt.executeQuery(sql);
		
	}
	
}
