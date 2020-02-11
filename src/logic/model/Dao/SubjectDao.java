package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import logic.Session;
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
            	String abbreviation = rs.getString("Sigla");
            	double index = rs.getDouble("Indice");
            	
            	subjectOfLesson = new Subject(name, abbreviation, index);
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
		
		Statement stmt = null;
        Connection conn = null;
        ArrayList<Subject> subject;
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = SubjectQueries.findSubjectOfStudent(stmt, Session.getSession().getStudent().getUsername());
            
            if (!rs.first()){
            	subject = null;
            }else {
            	//returned one value
            	rs.first();
            	subject = new ArrayList<Subject>();
            	do{
            		String name = rs.getString("Materia");
                	String abbreviation = rs.getString("Sigla");
                	double index = rs.getDouble("Indice");
                    Subject sub = new Subject(name,abbreviation,index);
                   
                    subject.add(sub);

                }while(rs.next());
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
		
		return subject;
		
	}
	
	public static Subject getSubjectByName(String name) throws SQLException {
		Statement stmt = null;
        Connection conn = null;
        Subject subject = null;
		
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = SubjectQueries.findSubjectByName(stmt, name);
            //check if a returned zero value
            if (!rs.first()){
            	subject = null;
            }else {
            	//returned one value
            	rs.first();
            	String nm = rs.getString("Nome");
            	String abbreviation = rs.getString("Sigla");
            	double index = rs.getDouble("Indice");
            	
            	subject = new Subject(nm, abbreviation, index);
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
        	return subject;
		
	}
}
