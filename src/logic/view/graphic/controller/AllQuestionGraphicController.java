package logic.view.graphic.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.view.NamePage;

public class AllQuestionGraphicController extends GraphicController{
	
	@FXML
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	@FXML
	public void newQuestButton(ActionEvent e) throws IOException {
		goToPage(NamePage.QUESTIONTYPE);
	}
	
}
