package logic.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.bean.StudentBean;
import logic.model.SingletonConnectionDB;
import logic.model.Student;
import logic.model.StudentQueries;

public class StudentDao {	

    public static Student findStudentLog(StudentBean potentialStud) throws SQLException {
        Statement stmt = null;
        Connection conn = null;
        Student studLog = null;
        
        try {
        	
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	
            ResultSet rs = StudentQueries.selectStudent(stmt, potentialStud.getUsername(), potentialStud.getPassword());

            if (!rs.first()){
            	studLog = null;
            }else {
            	rs.first();
            
            	String nome = rs.getString("Nome");
            	String cognome = rs.getString("Cognome");
            	String username = rs.getString("Username");
            	String password = rs.getString("Password");
	        
            	studLog = new Student(nome,cognome,username,password);
            	SingletonConnectionDB.studLog = studLog;
            }
            
            rs.close();
            stmt.close();
        } finally {      
            try {
                if (conn != null && studLog == null) {
                	conn.close();
                }    
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
	
        return studLog;
    }
}