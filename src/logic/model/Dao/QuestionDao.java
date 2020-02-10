package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import execption.QuestionException;
import logic.model.Question;
import logic.model.QuestionExercise;
import logic.model.QuestionType;
import logic.model.SingletonConnectionDB;
import logic.model.queries.QuestionQueries;

public class QuestionDao {
	protected Statement stmt;
    protected Connection conn;
   
    
	public int getNewId() throws SQLException {
		/*
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = QuestionQueries.getId(stmt);
		
		
		return rs.getInt("count")+1;
		
		}
		finally {
			
		}
		*/
		return 12;
	}
	
	public void saveOnDB(Question question,QuestionType type) throws SQLException, QuestionException {
		
		

		String text;

		
		
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
           
            //QuestionQueries.saveQuestionExercise(stmt, this.question.id, this.question.getTitle(),this.question.getText(),this.question.getImage(), false);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		
		try {
			text = (String) question.getClass().getMethod("getText").invoke(question);
			
		}
		catch(ReflectiveOperationException e) {
			throw new QuestionException("Error on save DB");
		}
		
		switch(type) {
			
			case EXERCISE:
				QuestionQueries.saveQuestion(stmt,question.id, question.getTitle(), text, null, question.solved);
				
			case PROBLEM:
				String image;
				try {
					image = (String) question.getClass().getMethod("getImage").invoke(question);
					
				}
				catch(ReflectiveOperationException e) {
					throw new QuestionException("Error on save DB");
				}
				
				QuestionQueries.saveQuestion(stmt,question.id, question.getTitle(), text, image, question.solved);
		}
		
		
		
		
	}
	
	
	public void saveOnDBFake(Question question,QuestionType type) {
		
	}

}
