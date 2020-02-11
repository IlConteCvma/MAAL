package logic.model.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestionQueries {
	public static void saveQuestion(Statement stmt,int id,String title,String text,String image,boolean validate,String type, String namestud,String namesub) throws SQLException  {
		//String sql = null;
		//String sql = "SELECT * FROM Studente where Username = '" + username + "'and Password = '"+password+"';";
		
		String sql =" INSERT INTO domandaproposta (ID,Titolo,Testo,Immagine,Risolto,Tipo,Studente,Materia) VALUES ("+id+",'"+title+"','"+text+"','"+image+"',"+validate+", '"+type+"','"+namestud+"','"+namesub+"');";
		
		
		//Aggiugere la quary
		stmt.executeUpdate(sql);
	}

	public static ResultSet getId(Statement stmt) throws SQLException {
		String sql ="SELECT count(*) AS count FROM domandaaccettata ;";
		return stmt.executeQuery(sql);
		
	}
	
}
