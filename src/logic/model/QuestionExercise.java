package logic.model;

public class QuestionExercise extends Question {

	protected String textualContent;
	protected String image;
	
	public QuestionExercise() {

	}
	
	public QuestionExercise(String text) {
		this.textualContent = text;
	}
	
	public QuestionExercise(String text, String image) {
		this.textualContent = text;
		this.image = image;
	}
	
	
	public void setText(String newText) {
		this.textualContent = newText;
	}
	public String getText() {
		return this.textualContent;
	}
	
	public void setImage(String newImage) {
		this.image = newImage;
	}
	
	public String getImage() {
		return this.image;
	}

}
