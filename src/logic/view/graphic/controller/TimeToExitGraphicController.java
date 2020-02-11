package logic.view.graphic.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import logic.bean.TimeToExitBean;
import logic.view.ViewComponent;
import logic.view.graphic.elements.AnchorPaneComponent;

public class TimeToExitGraphicController extends GraphicController implements Initializable{

	private TimeToExitBean timeToExitBean;
	private AnchorPaneComponent anchorPane;
	
	@FXML private AnchorPane anchorPaneContainer;
	@FXML private Label nextLessonLabel;
	@FXML private Label nextRoomLabel;
	@FXML private Label minuteToExitLabel;
	@FXML private Label prioritySeatLabel;
	
	public TimeToExitGraphicController(TimeToExitBean timeToExitBean) {
		this.timeToExitBean = timeToExitBean;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nextLessonLabel.setText(timeToExitBean.getNextLesson().getSubjectLesson().getAbbrevation());
		nextRoomLabel.setText("ROOM "+timeToExitBean.getNextLesson().getRoomLesson().getName());
		minuteToExitLabel.setText(""+ timeToExitBean.getMinuteToExit());
		prioritySeatLabel.setText("FOR SEATS IN THE BAND " + timeToExitBean.getPriority());
	}
	
	@FXML
	public void goToOccupateSeat() {
		anchorPane = new AnchorPaneComponent(10,122);
		AnchorPaneRoom anchorPaneRoom = new AnchorPaneRoom(anchorPane, timeToExitBean.getNextLesson());
		anchorPaneContainer.getChildren().add(anchorPaneRoom.draw());
	}
	
	@FXML
	public void goToMap() {
		System.out.println("MAPPA");
	}

}