package logic.view.graphicController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import logic.MainClass;

public class NavbarGraphicController {
	
	@FXML
	public void homeButton(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../resources/HomeView.fxml"));
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
	public void logOutButton(MouseEvent e) throws IOException {
		goToLoginPage();
	}
	
	public void goToLoginPage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../resources/LoginView.fxml"));
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}				
}
