package logic.view.graphic.controller;

import javafx.fxml.*;
import javafx.scene.control.PasswordField;
import logic.bean.StudentBean;
import logic.controller.LoginController;
import logic.view.AlertControl;
import logic.view.NamePage;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginGraphicController extends GraphicController{
	
	@FXML private PasswordField psw;
	@FXML private TextField user;
	@FXML private AnchorPane rootPane;
	
	private static final String WARNING = "WARNING";
	LoginController lg = new LoginController();
	
	@FXML
	public void signIn(ActionEvent e) throws IOException, SQLException {
		
		StudentBean possibleStudent = new StudentBean();
		possibleStudent.setUsername(user.getText());
		possibleStudent.setPassword(psw.getText());
		if(lg.login(possibleStudent)) {
			goToPage(NamePage.HOME);
		}else {
			AlertControl.infoBox("Data are strong", WARNING);
		}
		
	}
	
	
	public void forgotPassword() {
		AlertControl.infoBox("Operation not available", WARNING);
	}
	
	public void signUp() {
		AlertControl.infoBox("Operation not available", WARNING);
	}

}
