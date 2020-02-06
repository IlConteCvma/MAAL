package logic.model;

import execption.QuestionException;

public abstract class Question {
	public int id;
	public boolean solved; 
	protected String title;
	
	
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public void setSolved() throws QuestionException {
		if(!solved) {
			solved = true;
		}
		else {
			throw new QuestionException("Question already solved");
		}
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
}
	
