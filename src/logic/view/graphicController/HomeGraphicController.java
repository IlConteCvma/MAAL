package logic.view.graphicController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import logic.MainClass;
import logic.controller.ViewTimeToExitController;
import logic.model.SingletonConnectionDB;
import logic.view.LoginPage;


public class HomeGraphicController implements Initializable{

	private LoginGraphicController controLog = new LoginGraphicController();
	private ViewTimeToExitController controlUC = new ViewTimeToExitController();
	
	@FXML private Label dataOfStudent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataOfStudent.setText(""+SingletonConnectionDB.getStudent().getName()+" "+SingletonConnectionDB.getStudent().getSurname());
	}
	
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
	
	public void logOutButton(ActionEvent e) throws IOException {
		goToLoginPage();
	}
	public void getStarted(ActionEvent e) {
		controlUC.estimateTimeToExit();
	}
	
	public void goToLoginPage() throws IOException {
		LoginPage root = new LoginPage();
		
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}
	
	
	
	
}
