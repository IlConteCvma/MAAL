package logic.controller;

import java.time.ZonedDateTime;
import logic.model.Seat;
import logic.model.Student;

public class ViewTimeToExitController {

	private ViewNextLessonController nextLesson = new ViewNextLessonController();
	private Student studLogged;
	
	public void getInfoByMaps() {
		//in lavorazione..
	}
	
	public void getInfoByMeteo() {
		//in lavorazione..
	}
	
	public void estimateTimeToExit() {
		int actualHour[] = new int[3]; 
		actualHour = nextLesson.getActualHour();
	}
	
	public void estimateOccupationRoom() {
		//in lavorazione..
	}
	
	public void occupateSeat(Seat seatToOccupy) {
		seatToOccupy.occupateSeat();
	}

}
