package logic.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatQueries {

	public static ResultSet findSeatsOfRoom(Statement stmt, String nameRoom) throws SQLException  {
		String sql = "SELECT * FROM posto WHERE Aula = '" + nameRoom +"';";
		
		System.out.println(sql);
		return stmt.executeQuery(sql);
	}
		
}