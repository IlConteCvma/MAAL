package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import logic.model.Seat;
import logic.model.SeatQueries;
import logic.model.SingletonConnectionDB;

public class SeatDao {
	
public Vector<Seat> getSeatsOfRoom(String nameRoom) throws SQLException {
        
	 	Statement stmt = null;
        Connection conn = null;
        Vector<Seat> seatsOfRoom;
        
        try {
        	//create connection
        	conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	//create statement
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	//execute query
            ResultSet rs = SeatQueries.findSeatsOfRoom(stmt, nameRoom);
            //check if a returned zero value
            if (!rs.first()){
            	seatsOfRoom = null;
            }else {
            	//returned one value
            	rs.first();
            	seatsOfRoom = new Vector<Seat>();
            	do{
            		int idSeat = rs.getInt("ID");
            		boolean busy = rs.getBoolean("Busy");
                    Seat place = new Seat(idSeat, busy);
                    
                    seatsOfRoom.add(place);

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
        	return seatsOfRoom;
    }
}
