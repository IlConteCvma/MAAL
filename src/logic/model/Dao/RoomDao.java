package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.Room;
import logic.model.RoomQueries;
import logic.model.SingletonConnectionDB;

public class RoomDao {
	
	//private NextLessonDao abc = new NextLessonDao();
	
	public String getInfoRoomByIdLesson(int idLesson) throws SQLException {
        
	 	Statement stmt = null;
        Connection conn = null;
        String nameRoomOfLesson;
        boolean firstTime = true;
        
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = RoomQueries.findNameRoomByIdLesson(stmt, idLesson);
            //check if a returned zero value
            if (!rs.first()){
            	nameRoomOfLesson = null;
            }else {
            	//returned one value
            	rs.first();
            	
            	nameRoomOfLesson = rs.getString("Nome");
            }
            rs.close();
            } finally {     
            	if(stmt != null){
            		stmt.close();
            	}
            	try {
            		if (conn != null && firstTime == false) {
            			conn.close();
            		}    
            	} catch (SQLException se) {
            		se.printStackTrace();
            	}
            }
        	return nameRoomOfLesson;
	}
	
	public Room getRoom(String nameRoom)  throws SQLException {
        
	 	Statement stmt = null;
        Connection conn = null;
        Room roomOfLesson;
        
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = RoomQueries.findInfoRoom(stmt, nameRoom);
            //check if a returned zero value
            if (!rs.first()){
            	roomOfLesson = null;
            }else {
            	//returned one value
            	rs.first();
            	String name = rs.getString("Nome");
            	int numRow = rs.getInt("NumRighe");
            	int numColumn = rs.getInt("NumColonne");
            	
            	roomOfLesson = new Room(name, numRow, numColumn, null/*abc.getSeatsOfRoom()*/);
            	
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
        	return roomOfLesson;
    }
	
}
