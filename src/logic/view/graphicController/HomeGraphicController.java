package logic.view.graphicController;


import java.io.IOException;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import logic.MainClass;


public class HomeGraphicController {

	
	@FXML
	public void homeButton(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/resources/HomeView.fxml"));
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}
	
	public void calendarButton(MouseEvent e) {
		System.out.println("CALENDAR");
	}
	
	public void forumButton(MouseEvent e) {
		System.out.println("FORUM");
	}
	
	public void profileButton(MouseEvent e) {
		System.out.println("PROFILE");
	}
	
	public void todayLessonButton(MouseEvent e) {
		System.out.println("LESSON");
	}
	
	public void communicationButton(MouseEvent e) {
		System.out.println("COMMUNICATION");
	}
	
	public void nextLessonButton(MouseEvent e) {
		System.out.println("NEXT Lesson");
	}
	
	public void logOutButton(MouseEvent e) throws IOException {
		goToLoginPage();
	}
	
	public void getStarted(MouseEvent e) {
		controlUC.estimateTimeToExit();
	}
	
	public void goToLoginPage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/resources/LoginView.fxml"));
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}
	
	
	
	
}
