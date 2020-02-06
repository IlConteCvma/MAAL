package logic.model.Dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import logic.model.QuestionExercise;
import logic.model.QuestionQueries;
import logic.model.SingletonConnectionDB;

public class QuestionExerciseDao extends QuestionDao{
	private QuestionExercise question;
	
    
	public void saveOnDB(QuestionExercise question) throws SQLException {
		this.question=question;
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
           
            QuestionQueries.saveQuestionExercise(stmt, this.question.id, this.question.getTitle(),this.question.getText(),this.question.getImage(), false);
		}
		finally {
			
		}
		
		
	}

}
