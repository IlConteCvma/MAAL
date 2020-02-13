package logic.model.dao;

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
    protected static Connection connection;
    
    private QuestionDao() {
        throw new IllegalStateException("Utility class");
      }
   
    
	public static int getNewId() throws SQLException {
		int count;
		try {
			connection = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
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
          	if (connection != null) {
  				SingletonConnectionDB.close();
  			}
          }
      	return count+1;
		

	}
	
	public static void saveOnDB(Question question,QuestionType type) throws QuestionException  {
		
		

		String text;

		
		
		try {
			connection = (SingletonConnectionDB.getSingletonConnection()).getConnection();
        	
            stmt = connection.createStatement();
    
           
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
				QuestionQueries.saveQuestion(stmt,question ,text, null,type.toString());
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
				QuestionQueries.saveQuestion(stmt,question, text, image,type.toString());
				}
				catch(SQLException e) {
					throw new QuestionException(e.getMessage());
				}
				break;
				
				default:
					throw new QuestionException("Error in question type");
				
				
		}
		
		
		
		
	}
	

}
