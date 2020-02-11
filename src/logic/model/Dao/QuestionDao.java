package logic.model.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import execption.QuestionException;
import logic.model.Question;

import logic.model.QuestionType;
import logic.model.SingletonConnectionDB;
import logic.model.queries.QuestionQueries;

public class QuestionDao {
	protected static Statement stmt;
    protected static Connection conn;
   
    
	public static int getNewId() throws SQLException {
		int count;
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
		ResultSet rs = QuestionQueries.getId(stmt);
		
		  if (!rs.first()){
			  count = 0;
          }else {
          	//returned one value
          	rs.first();
          	count = rs.getInt("count");
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
      	return count+1;
		

	}
	
	public static void saveOnDB(Question question,QuestionType type) throws QuestionException  {
		
		

		String text;

		
		
		try {
			conn = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = conn.createStatement();
    
           
		}
		catch(SQLException e) {
			throw new QuestionException(e.getMessage());
		}
			
		
		try {
			text = (String) question.getClass().getMethod("getText").invoke(question);
			
		}
		catch(ReflectiveOperationException e) {
			throw new QuestionException("Error on invoke for text");
		}
		
		switch(type) {
			
			case PROBLEM:
				
				try {
				QuestionQueries.saveQuestion(stmt,question.getId(), question.getTitle(), text, null, question.isSolved(),type.toString(),question.getStudent().getUsername(),question.getQuestionSub().getName());
				}
				catch(SQLException e) {
					throw new QuestionException(e.getMessage());
					
				}
				break;
				
			case EXERCISE:
				
				String image;
				try {
					image = (String) question.getClass().getMethod("getImage").invoke(question);
					
				}
				catch(ReflectiveOperationException e) {
					throw new QuestionException("Error on invoke for image");
				}
				try {
				QuestionQueries.saveQuestion(stmt,question.getId(), question.getTitle(), text, image, question.isSolved(),type.toString(),question.getStudent().getUsername(),question.getQuestionSub().getName());
				}
				catch(SQLException e) {
					throw new QuestionException(e.getMessage());
				}
				break;
				
				
		}
		
		
		
		
	}
	

}
