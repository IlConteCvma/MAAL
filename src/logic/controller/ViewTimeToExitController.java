package logic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;
import logic.model.DateApi;
import logic.model.MapsApi;
import logic.model.Seat;
import logic.model.WeatherApi;

public class ViewTimeToExitController {

	private ViewNextLessonController nextLessonController = new ViewNextLessonController();
	private DateApi time;
	private MapsApi map;
	private WeatherApi weather;
	private Vector<Double> originAddress;
	private Vector<Double> destinationAddress;
	private Double distance;
	
	public void getInfoByMaps() throws IOException {
		map = new MapsApi();
		//Calculate latitudine and longituidine(?) 
		this.originAddress= map.getPosition("La Rustica");
		this.destinationAddress = map.getPosition("Centocelle");
		//Calculate distance in km
		this.distance = map.calculateDistance(originAddress,destinationAddress);
	}
	
	public void getInfoByMeteo() {
		//in lavorazione..
	}
	
	public void estimateTimeToExit() throws IOException, SQLException {
		getInfoByMaps();
		this.distance = this.distance + 0.14 * this.distance; //aggiungo il 14%
		System.out.println(this.distance);
		time = new DateApi();
		Vector<Integer> actualHour = new Vector<>();
		actualHour = time.getActualHour();
		getNextLesson();
		System.out.println("L'ora esatta è " + actualHour.elementAt(0) + ":" + actualHour.elementAt(1) + ":" + actualHour.elementAt(2)); 
	}
	
	public void getNextLesson() throws SQLException {
		nextLessonController.getNextLesson();
	}
	
	public void estimateOccupationRoom() {
		//in lavorazione..
	}
	
	public void occupateSeat(Seat seatToOccupy) {
		seatToOccupy.occupateSeat();
	}
}