package logic.view.graphic.controller;

import javafx.fxml.*;
import javafx.scene.control.PasswordField;
import logic.AlertControl;
import logic.bean.StudentBean;
import logic.controller.LoginController;
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
	
	LoginController lg = new LoginController();
	
	@FXML
	public void signIn(ActionEvent e) throws IOException, SQLException {
		StudentBean possibleStudent = new StudentBean();
		possibleStudent.setUsername(user.getText());
		possibleStudent.setPassword(psw.getText());
		if(lg.login(possibleStudent)) {
			goToPage(NamePage.HOME);
		}else {
			AlertControl.infoBox("Data are strong", "WARNING");
		}
		//goToPage(NamePage.HOME);
	}
	
	
	public void forgotPassword(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}
	
	public void signUp(ActionEvent e) {
		AlertControl.infoBox("Operation not available", "WARNING");
	}

}
