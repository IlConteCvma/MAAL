package logic.view.graphic.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class NavbarGraphicController {
	
	private HomeMenuGraphicController controlHome = new HomeMenuGraphicController();
	
	@FXML
	public void homeButton(ActionEvent e) throws IOException {
		controlHome.homeButton(e);
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
	public void logOutButton(ActionEvent e) throws IOException {
		controlHome.goToLoginPage();
	}
			
}