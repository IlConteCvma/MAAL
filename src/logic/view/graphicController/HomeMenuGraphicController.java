package logic.view.graphicController;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Scene;
import logic.MainClass;
import logic.view.Page;
import logic.view.PageFactory;


public class HomeMenuGraphicController{

	private LoginGraphicController controLog = new LoginGraphicController();
	
	@FXML
	public void homeButton(ActionEvent e) throws IOException {
		controLog.goToHomepage();
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
		goToLoginPage();
	}

	
	public void goToLoginPage() throws IOException {
		Page root = PageFactory.createPage("logPage");
		
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}
	
	
	
	
}
