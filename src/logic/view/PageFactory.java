package logic.view;

import java.io.IOException;
import logic.view.NamePage;

public class PageFactory {
	
	private PageFactory() {
		
	}
	
	public static Page createPage(NamePage type) throws IOException{
	
		switch(type) {
			case HOME: return new HomePage();
			case LOGIN: return new LoginPage();
			case QUESTIONTYPE: return new TypeQuestionPage();
			case TIMETOEXIT: return new HomeTimePage();
			
			default: throw new IOException("Invalid type : " + type);
			
		}	

	}
	
	public static Page createPage(NamePage type,String args[]) throws IOException {
		
		switch(type) {
		
			case EXERCISE: return new QuestionExercisePage(args[0]);
			case PROBLEM: return new QuestionProblemPage(args[0]);
			
		default: throw new IOException("Invalid type or args");
		}
		
		
		
	}
}
