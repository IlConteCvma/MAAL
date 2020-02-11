package logic.view.graphic.controller;


import java.io.IOException;

import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import logic.MainClass;
import logic.Session;
import logic.bean.SubjectBean;
import logic.controller.InsertQuestionController;

import logic.view.NamePage;
import logic.view.Page;
import logic.view.PageFactory;
import logic.view.QuestionExercisePage;
import logic.view.QuestionProblemPage;


public class TypeQuestionGraphicController extends GraphicController{
	
	@FXML Button clickMe;
	@FXML Button buttonExe;
	@FXML Button buttonPro;
	@FXML GridPane gridPane;
	private String subSelect;
	
	
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	

	public void typeExercise(ActionEvent e) throws IOException {
		//goToPage(NamePage.EXERCISE);
		Page root = new QuestionExercisePage(this.subSelect);
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
		
		
		
	}
	public void back(ActionEvent e) {
		System.out.println("Tutte le question Caso d'uso");
	}
	
	public void typeProblem(ActionEvent e) throws IOException {
		//goToPage(NamePage.PROBLEM);
		Page root = new QuestionProblemPage(this.subSelect);
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
		
	}
	

	public void mySubject(ActionEvent e) {
		InsertQuestionController controller = new InsertQuestionController();
		ArrayList<SubjectBean> bean = controller.getSubjects();
		gridPane.setVgap(25);
		gridPane.setHgap(1);
		
		if(bean != null) {
			int row = 0;
			int col = 0;
			for(int i=0; i<bean.size();i++) {
				
				if(i%4 == 0 && i !=0) {
					row++;
				}
				if (col%4 == 0) {
					col = 0;
				}
				
				showSubject(bean.get(i).getName(),bean.get(i).getAbbrevation(),row,col);
				col++;
			}
			clickMe.setDisable(true);
		}
		
		else {
			Label text = new Label();
			text.setMinSize(110, 30);
			text.setText("You don't follow any \nsubject\nCheck your profile");
			text.setTextAlignment(TextAlignment.CENTER);
			clickMe.setDisable(true);
			
			this.gridPane.getChildren().add(text);
		}
		
	}
	
	
	private void showSubject(String name,String abbr,int row,int col) {
		Button subj = new Button();
		subj.setText(abbr);
		subj.setAccessibleText(name);
		subj.setMinSize(130, 50);
		
		
		
		
		
		subj.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				subj.setStyle("-fx-background-color: #0bbd3d;");
				
				//ArgumentToPage.getSession().setSubjChoose(subj.getAccessibleText());
				subSelect = subj.getAccessibleText();
				
				buttonPro.setDisable(false);
				buttonExe.setDisable(false);
				gridPane.setDisable(true);
				
			}
		

		});
		
		gridPane.add(subj, col, row);
		
	}
	



}
