package logic.view.graphic.controller;

import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import logic.MainClass;
import logic.bean.StudentBean;
import logic.controller.LoginController;
import logic.view.Page;
import logic.view.PageFactory;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginGraphicController{
	
	@FXML private PasswordField psw;
	@FXML private TextField user;
	@FXML private AnchorPane rootPane;
	
	LoginController lg = new LoginController();
	
	@FXML
	public void signIn(ActionEvent e) throws IOException, SQLException {
		 /*
		 StudentBean studLog = new StudentBean();
		 studLog.setUsername(user.getText());
		 studLog.setPassword(psw.getText());
		 
		 if(lg.login(studLog)) {
			goToHomepage();
		 }
		 */
		 goToHomepage();
	}
	
	public void goToHomepage() throws IOException {
		/*
		Parent root = FXMLLoader.load(getClass().getResource("resources/HomeView.fxml"));
		*/
		Page root = PageFactory.createPage("homePage");
		Scene scene = new Scene(root);
		MainClass.getStage().setScene(scene);
	}
	
	public void forgotPassword(ActionEvent e) {
		System.err.println("Remember");
	}
	
	public void signUp(ActionEvent e) {
		System.err.println("Sign Up");
	}

}