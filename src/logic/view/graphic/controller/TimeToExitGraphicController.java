package logic.view.graphic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import logic.Session;

public class TimeToExitGraphicController extends GraphicController implements Initializable{

	@FXML private Label nextLessonLabel;
	@FXML private Label nextRoomLabel;
	@FXML private Label minuteToExitLabel;
	@FXML private Label prioritySeatLabel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nextLessonLabel.setText(Session.getSession().getNextLesson().getSubjectLesson().getAbbrevation());
		nextRoomLabel.setText("ROOM "+Session.getSession().getNextLesson().getRoomLesson().getName());
		minuteToExitLabel.setText(""+ Session.getSession().getMinutes());
		prioritySeatLabel.setText("FOR SEATS IN THE BAND " + Session.getSession().getPriority());
	}
	
	public void goToOccupateSeat(int row) {
		//ucController.occupateSeat(seatOccuped);
	}
	
	public void reportAlert() {
		
	}

}