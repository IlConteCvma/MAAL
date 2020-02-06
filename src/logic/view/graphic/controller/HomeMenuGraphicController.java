package logic.view.graphic.controller;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import logic.view.NamePage;



public class HomeMenuGraphicController extends GraphicController {

	
	@FXML
	public void homeButton(ActionEvent e) throws IOException {
		goToPage(NamePage.HOME);
	}
	
	public void calendarButton(ActionEvent e) {
		System.out.println("CALENDAR");
	}
	
	public void forumButton(ActionEvent e) {
		System.out.println("FORUM");
	}
	
	public void profileButton(ActionEvent e) {
		System.out.println("PROFILE");
	}
	
	public void todayLessonButton(ActionEvent e) {
		System.out.println("LESSON");
	}
	
	public void communicationButton(ActionEvent e) {
		System.out.println("COMMUNICATION");
	}
	
	public void nextLessonButton(ActionEvent e) {
		System.out.println("NEXT Lesson");
	}
	
	public void logOutButton(ActionEvent e) throws Exception {
		goToPage(NamePage.LOGIN);
	}

	
	
	
}
