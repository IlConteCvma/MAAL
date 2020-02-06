package logic.model.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import logic.model.QuestionProblem;
import logic.model.QuestionQueries;
import logic.model.SingletonConnectionDB;

public class QuestionProblemDao extends QuestionDao {
	private QuestionProblem question;

	public void saveOnDB(QuestionProblem question) throws SQLException {
		this.question=question;
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
           
            QuestionQueries.saveQuestionProblem(stmt, this.question.id, this.question.getTitle(),this.question.getText(), false);
		}
		finally {
			
		}
		
		
	}



}
