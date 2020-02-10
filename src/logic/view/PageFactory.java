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
			case EXERCISE: return new QuestionExercisePage();
			case PROBLEM : return new QuestionProblemPage();
			case TIMETOEXIT: return new HomeTimePage();
			
			default: throw new IOException("Invalid type : " + type);
			
		}		
	}
}
