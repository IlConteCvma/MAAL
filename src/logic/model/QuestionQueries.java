package logic.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionQueries {
	public static void saveQuestionExercise(Statement stmt,int id,String title,String text,String image,boolean validate ) throws SQLException  {
		String sql = null;
		//String sql = "SELECT * FROM Studente where Username = '" + username + "'and Password = '"+password+"';";
		//Aggiugere la quary
		stmt.executeQuery(sql);
	}
	
	public static void saveQuestionProblem(Statement stmt,int id,String title,String text,boolean validate) throws SQLException  {
		String sql = null;
		//String sql = "SELECT * FROM Studente where Username = '" + username + "'and Password = '"+password+"';";
		//Aggiugere la quary
		stmt.executeQuery(sql);
	}
	public static ResultSet getId(Statement stmt) throws SQLException {
		String sql ="SELECT count(*) AS count FROM Question ;";
		return stmt.executeQuery(sql);
		
	}
	
}
