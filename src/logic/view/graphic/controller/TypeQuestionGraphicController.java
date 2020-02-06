package logic.view.graphic.controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import logic.view.NamePage;

public class TypeQuestionGraphicController extends GraphicController{
	
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	

	public void typeExercise() throws IOException {
		//this.factory = new QuestionExerciseFactory();
		goToPage(NamePage.EXERCISE);
		
		
	}
	public void back() {
		System.out.println("Tutte le question Caso d'uso");
	}
	
	public void typeProblem() throws IOException {
		//this.factory = new QuestionProblemFactory();
		goToPage(NamePage.PROBLEM);
		
	}
	
	/*
	public void commit() {
		this.dataBean = this.factory.createBean();
		//popolo la bean
		
		QuestionController controller = new InsertQuestionController(factory,dataBean);
		controller.newQuestion();
	}
	*/
}
