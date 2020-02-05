package logic.view.graphicController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import logic.controller.ViewTimeToExitController;
import logic.model.SingletonConnectionDB;

public class HomeBoxGraphicController implements Initializable{

	private ViewTimeToExitController controlUC = new ViewTimeToExitController();
	
	@FXML private Label dataOfStudent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//dataOfStudent.setText(""+SingletonConnectionDB.getStudent().getName()+" "+SingletonConnectionDB.getStudent().getSurname());
	}
	
	public void getStarted(ActionEvent e) {
		controlUC.estimateTimeToExit();
	}
}
