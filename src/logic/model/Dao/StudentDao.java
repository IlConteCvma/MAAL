package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.SingletonConnectionDB;
import logic.model.Student;
import logic.model.StudentQueries;

public class StudentDao {	

    public static Student findStudentLog(String possibleUsername, String possiblePassword) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        Student studLog = null;
        boolean firstTime = true;
        
        try {
        	
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	
            ResultSet rs = StudentQueries.selectStudent(stmt, possibleUsername, possiblePassword);

            if (!rs.first()){
            	studLog = null;
            }else {
            	rs.first();
            	firstTime = false;
            	String nome = rs.getString("Nome");
            	String cognome = rs.getString("Cognome");
            	String username = rs.getString("Username");
            	String password = rs.getString("Password");
	        
            	studLog = new Student(nome,cognome,username,password);
            	SingletonConnectionDB.studLog = studLog;
            }
            
            rs.close();
        } finally {     
        	if(stmt != null){
        		stmt.close();
        	}
            try {
                if (conn != null && studLog == null && firstTime == false) {
                	conn.close();
                }    
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
        return studLog;
    }
}