package logic.view.graphic.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import logic.model.Lesson;
import logic.model.Room;
import logic.view.ViewComponent;

public class AnchorPaneRoom extends Decorator{

	private Room roomLesson;
	
	public AnchorPaneRoom(ViewComponent anchorPaneComponent, Lesson lesson) {
		super(anchorPaneComponent);
		this.roomLesson = lesson.getRoomLesson();
	}
	
	public AnchorPane createRoom(AnchorPane anchorPane) {
		GridPane room = new GridPane();
		
		for (int i = 0; i < roomLesson.getNumRow(); i++) {
            RowConstraints rowConst = new RowConstraints();
            room.getRowConstraints().add(rowConst);         
        }
		
		for (int i = 0; i < roomLesson.getNumColumn(); i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            room.getColumnConstraints().add(colConst);
        }
		
        for(int i = 0; i < roomLesson.getNumRow();i++) {
			for(int j = 0; j < roomLesson.getNumColumn();j++) {
				Button b = new Button(""+((roomLesson.getNumColumn()*i)+j));
				room.add(b, i, j);
	        }
        }
        
        anchorPane.getChildren().add(room);
		return anchorPane;
	}

	@Override
	public AnchorPane draw() {
		AnchorPane preliminaryResults = super.draw();
		preliminaryResults = this.createRoom(preliminaryResults);
		return preliminaryResults;
	}
}
