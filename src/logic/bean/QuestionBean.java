package logic.bean;

import logic.model.QuestionType;

public abstract class QuestionBean {
	private QuestionType type;
	private String title;
	
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
