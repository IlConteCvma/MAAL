package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.model.Lesson;
import logic.model.LessonQueries;
import logic.model.SingletonConnectionDB;
import logic.model.Subject;

public class LessonDao {
	 public static Lesson findNextLesson(int seconds) throws SQLException {
	        Statement stmt = null;
	        Connection conn = null;
	        Lesson nextLesson = null;
	        
	        try {
	        	
	        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
	        	
	        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	        	
	            ResultSet rs = LessonQueries.selectNextLesson(stmt, seconds);

	            if (!rs.first()){
	            	nextLesson = null;
	            }else {
	            	rs.first();
	            	nextLesson = new Lesson(17,18,0,null,null);
	            }
	            
	            rs.close();
	        } finally {     
	        	if(stmt != null){
	        		stmt.close();
	        	}
	        	
	            try {
	                if (conn != null) {
	                	conn.close();
	                }    
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
		
	        return nextLesson;
	    }
}
