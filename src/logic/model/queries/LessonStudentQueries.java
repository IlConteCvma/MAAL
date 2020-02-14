package logic.model.queries;

import java.sql.SQLException;
import java.sql.Statement;

public class LessonStudentQueries {

	public static int followNewSubject(Statement stmt, String username, String nameSubject) throws SQLException  {
		
		String sql = "INSERT INTO `segue` (`Studente`, `Materia`) VALUES ('"+username+"', '"+nameSubject+"');";
		
		return stmt.executeUpdate(sql);
	}
	
}
