package logic.view.graphic.controller;


import java.io.IOException;

import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

import logic.Session;
import logic.bean.SubjectBean;
import logic.controller.InsertQuestionController;
import logic.view.NamePage;


public class TypeQuestionGraphicController extends GraphicController{
	
	@FXML Button clickMe;
	@FXML Button buttonExe;
	@FXML Button buttonPro;
	@FXML GridPane gridPane;
	
	
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
		ArrayList<SubjectBean> bean = controller.getSubjects();
		if(bean != null) {
			for(int i=0; i<bean.size();i++) {
				showSubject(bean.get(i).getName());
			}
			clickMe.setDisable(true);
		}
		
		else {
			Label text = new Label();
			text.setText("You don't follow any subject\nCheck your profile");
			text.setTextAlignment(TextAlignment.CENTER);
			clickMe.setDisable(true);
			
			gridPane.getChildren().add(text);
		}
		
	}
	
	
	private void showSubject(String name) {
		Button subj = new Button();
		subj.setText(name);
		subj.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				subj.setDisable(true);
				Session.getSession().setSubject(subj.getText());
				buttonPro.setDisable(false);
				buttonExe.setDisable(false);
				
			}
		

		});
		
		gridPane.getChildren().add(subj);
		
	}
	



}
