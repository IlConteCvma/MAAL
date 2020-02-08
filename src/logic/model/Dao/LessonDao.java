package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import logic.model.Lesson;
import logic.model.LessonQueries;
import logic.model.SingletonConnectionDB;

public class LessonDao {
	
	 public int findIdNextLesson() throws SQLException {
	        
		 	Statement stmt = null;
	        Connection conn = null;
	        int id;
	        
	        try {
	        	//create connection
	        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
	        	//create statement
	        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        	//execute query
	            ResultSet rs = LessonQueries.selectNextLesson(stmt);
	            //check if a returned zero value
	            if (!rs.first()){
	            	id = 0; //lesson not found
	            }else {
	            	//returned one value
	            	rs.first();
	            	id = rs.getInt("ID");
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
	        	return id;
	    }
	 
	 public Lesson getLessonById(int idLesson) throws SQLException {
	        
		 	Statement stmt = null;
	        Connection conn = null;
	        Lesson nextLesson = null;
	        
	        try {
	        	//create connection
	        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
	        	//create statement
	        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        	//execute query
	            ResultSet rs = LessonQueries.selectInfoLessonById(stmt,idLesson);
	            //check if a returned zero value
	            if (!rs.first()){
	            	nextLesson = null; //lesson not found
	            }else {
	            	//returned one value
	            	rs.first();
	            	Time startHour = rs.getTime("OraInizio");
	            	Time endHour = rs.getTime("OraFine");
	            	int dayOfWeek = rs.getInt("Giorno");
	            	nextLesson = new Lesson(startHour,endHour,dayOfWeek);
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
	        	return nextLesson;
	    }
}
