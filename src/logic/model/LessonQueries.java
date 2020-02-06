package logic.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LessonQueries {
	public static ResultSet selectNextLesson(Statement stmt, int seconds) throws SQLException  {
		String sql = "SELECT * FROM Studente where Username = 'Root'and Password = '';";
		return stmt.executeQuery(sql);
	}
}
