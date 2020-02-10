package logic.view.graphic.controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import logic.bean.SubjectBean;
import logic.controller.InsertQuestionController;
import logic.view.NamePage;

public class TypeQuestionGraphicController extends GraphicController{
	
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	

	public void typeExercise(ActionEvent e) throws IOException {
		goToPage(NamePage.EXERCISE);
		
		
	}
	public void back(ActionEvent e) {
		System.out.println("Tutte le question Caso d'uso");
	}
	
	public void typeProblem(ActionEvent e) throws IOException {
		goToPage(NamePage.PROBLEM);
		
	}
	

	public void mySubject(ActionEvent e) {
		InsertQuestionController controller = new InsertQuestionController();
		SubjectBean bean = controller.getSubject();
		showSubject();
	}
	
	
	private void showSubject() {
		
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
