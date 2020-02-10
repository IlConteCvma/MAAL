package logic.view.graphic.controller;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import logic.view.AlertControl;
import logic.view.NamePage;



public class HomeMenuGraphicController extends GraphicController {

	
	@FXML
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	public void calendarButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void forumButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void profileButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void todayLessonButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void communicationButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void nextLessonButton(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void logOutButton(ActionEvent e) throws Exception {
		goToPage(NamePage.LOGIN);
	}

	
	
	
}
