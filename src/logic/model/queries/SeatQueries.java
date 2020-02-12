package logic.model.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatQueries {

	public static ResultSet findSeatsOfRoom(Statement stmt, String nameRoom) throws SQLException  {
		String sql = "SELECT * FROM posto WHERE Aula = '" + nameRoom +"';";
		
		return stmt.executeQuery(sql);
	}

	public static int occupySeat(Statement stmt, String nameRoom, int idSeat) throws SQLException {
		String sql = "UPDATE `posto` SET `Busy` = '1' WHERE `posto`.`ID` = " + idSeat +" AND `posto`.`Aula` = '"+ nameRoom +"';";
		return stmt.executeUpdate(sql);
	}
}