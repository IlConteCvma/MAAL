package logic.model;

public class QuestionProblem extends Question {
	
	private String textualContent;
	
	public QuestionProblem() {
		
	}
	public QuestionProblem(String text) {
		this.setText(text);
	}

	@Override
	public void setTitle(String newTitle) {
		this.title = newTitle;
		
	}
	
	public void setText(String newText) {
		this.textualContent = newText;
	}
	public String getText() {
		return textualContent;
	}

}
