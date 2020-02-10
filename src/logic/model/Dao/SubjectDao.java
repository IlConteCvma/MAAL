package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.model.SingletonConnectionDB;
import logic.model.Subject;
import logic.model.queries.SubjectQueries;

public class SubjectDao {
	
	public Subject getSubjectLesson(int idLesson)  throws SQLException {
        
	 	Statement stmt = null;
        Connection conn = null;
        Subject subjectOfLesson = null;
        
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = SubjectQueries.findSubjectOfLesson(stmt, idLesson);
            //check if a returned zero value
            if (!rs.first()){
            	subjectOfLesson = null;
            }else {
            	//returned one value
            	rs.first();
            	String name = rs.getString("Materia");
            	double index = rs.getDouble("Indice");
            	
            	subjectOfLesson = new Subject(name, index);
            }
            rs.close();
            } finally {     
            	if(stmt != null){
            		stmt.close();
            	}
            	if (conn != null) {
    				SingletonConnectionDB.close();
    			}
            }
        	return subjectOfLesson;
    }
	
	public static ArrayList<Subject> getSubjectOfStudent(String username) throws SQLException{
		
		
		
		return null;
		
	}
}
