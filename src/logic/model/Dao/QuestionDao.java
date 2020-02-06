package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.QuestionQueries;
import logic.model.SingletonConnectionDB;

public abstract class QuestionDao {
	protected Statement stmt;
    protected Connection conn;
    
	public int getNewId() throws SQLException {
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = QuestionQueries.getId(stmt);
		
		
		return rs.getInt("count")+1;
		
		}
		finally {
			
		}
	}

}
