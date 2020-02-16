
package logic.view.graphic.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.json.JSONException;

import execption.EntityNotFoundException;
import execption.TimeException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import logic.MainClass;
import logic.Session;
import logic.bean.StudentBean;
import logic.bean.TimeToExitBean;
import logic.controller.ViewTimeToExitController;
import logic.view.AlertControl;
import logic.view.HomeTimePage;
import logic.view.Page;

public class HomeBoxGraphicController extends GraphicController{

	private ViewTimeToExitController controlUC = new ViewTimeToExitController();
	@FXML private Label dataOfStudent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataOfStudent.setText(""+Session.getSession().getStudent().getName()+" "+Session.getSession().getStudent().getSurname());
	}
	
	public void getStarted() throws IOException, SQLException  {
		StudentBean studLog = new StudentBean();
		studLog.setUsername(Session.getSession().getStudent().getUsername());
		try {
			TimeToExitBean timeToExit = controlUC.estimateTimeToExit();
			new TimeToExitGraphicController(timeToExit);
			
			Page root = new HomeTimePage(timeToExit);
			Scene scene = new Scene(root);
			MainClass.getStage().setScene(scene);
		} catch (TimeException e) {
			AlertControl.infoBox("It's too late", "I'm sorry");
		} catch (EntityNotFoundException e) {
			AlertControl.infoBox("Today you haven't lesson, you can relax!", "I'm happy for you!");
		} catch(JSONException e) {
			AlertControl.infoBox("Error request to secondary actor..Retry!", "Error request");
		}
	}
}
