package logic.view.graphic.controller;

import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import logic.MainClass;
import logic.controller.LoginController;
import logic.view.NamePage;
import logic.view.Page;
import logic.view.PageFactory;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginGraphicController extends GraphicController{
	
	@FXML private PasswordField psw;
	@FXML private TextField user;
	@FXML private AnchorPane rootPane;
	
	LoginController lg = new LoginController();
	
	@FXML
	public void signIn(ActionEvent e) throws IOException, SQLException {
		/*if(lg.login(user.getText(),psw.getText())) {
			goToHomepage();
		}*/
		goToPage(NamePage.HOME);
	}
	
	
	public void forgotPassword(ActionEvent e) {
		System.err.println("Remember");
	}
	
	public void signUp(ActionEvent e) {
		System.err.println("Sign Up");
	}

}
