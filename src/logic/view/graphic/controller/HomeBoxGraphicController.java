package logic.view.graphic.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import logic.controller.ViewTimeToExitController;
import logic.model.SingletonConnectionDB;

public class HomeBoxGraphicController extends GraphicController implements Initializable{

	private ViewTimeToExitController controlUC = new ViewTimeToExitController();
	
	@FXML private Label dataOfStudent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataOfStudent.setText(""+SingletonConnectionDB.getStudent().getName()+" "+SingletonConnectionDB.getStudent().getSurname());
	}
	
	public void getStarted(ActionEvent e) throws IOException, SQLException  {
		controlUC.estimateTimeToExit();
	}
}
