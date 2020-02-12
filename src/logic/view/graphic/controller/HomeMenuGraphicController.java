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
	
	public void calendarButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void forumButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void profileButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void todayLessonButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void communicationButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void nextLessonButton() {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void logOutButton() throws Exception {
		goToPage(NamePage.LOGIN);
	}

	
	
	
}
