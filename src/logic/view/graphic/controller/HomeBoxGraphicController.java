
package logic.view.graphic.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.json.JSONException;

import execption.AssistantException;
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
import logic.view.graphic.elements.PhraseSelector;

public class HomeBoxGraphicController extends GraphicController{

	private ViewTimeToExitController controlUC = new ViewTimeToExitController();
	@FXML private Label dataOfStudent;
	@FXML private Label textLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dataOfStudent.setText(""+Session.getSession().getStudent().getName()+" "+Session.getSession().getStudent().getSurname());
		
		try {
			this.textLabel.setText(PhraseSelector.select("src/logic/view/resources/HomePhrase.txt"));
		} catch (AssistantException e) {
			//default message
			this.textLabel.setText("Here to help");
		}
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
	
	@FXML
	public void getHelp() {
		AlertControl.infoBox("Sorry my programmers didn't give me a very rich vocabulary ... Click get started ", "Help page","Here to help");
	}
	
}
