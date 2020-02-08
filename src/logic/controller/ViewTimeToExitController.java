package logic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import logic.bean.StudentBean;
import logic.model.Lesson;
import logic.model.MapsApi;
import logic.model.Seat;
import logic.model.WeatherApi;

public class ViewTimeToExitController {

	private Lesson nextLesson;
	private ViewNextLessonController nextLessonController = new ViewNextLessonController();
	private MapsApi map;
	private WeatherApi weather;
	private Vector<Double> originAddress;
	private Vector<Double> destinationAddress;
	private Double distance;
	private Double lateForWeather = 0.0;
	private Double minutes;
	
	public void setDestinationAddress() {
		//Set destination address with data of University Of Tor Vergata
		destinationAddress = new Vector<Double>(2);
		destinationAddress.add(41.85);
		destinationAddress.add(12.63);
	}
	
	public void getInfoByMaps() throws IOException {
		this.map = new MapsApi();
		//Calculate latitude and longitude 
		this.originAddress= this.map.getPosition("Via Achille Vertunni");
		setDestinationAddress();
		//Calculate distance in km
		this.distance = this.map.calculateDistance(originAddress,destinationAddress);
	}
	
	public void getInfoByMeteo() throws IOException {
		this.weather = new WeatherApi();
		String rainIntensity = weather.getRainIntensity();
		if(rainIntensity.equals("Light")) {
			this.lateForWeather = 5.0;
		}else if(rainIntensity.equals("Moderate")){
			this.lateForWeather = 10.0;
		}
	}
	
	public void estimateTimeToExit(StudentBean studLog) throws IOException, SQLException {
		getInfoByMaps();
		this.distance = this.distance + 0.14 * this.distance; //add 14% -> value take by test
		this.minutes = (this.distance / (30*0.016)) + this.lateForWeather;
		System.out.println(this.minutes);
		getNextLesson();
	}
	
	public void getNextLesson() throws SQLException {
		nextLesson = nextLessonController.getNextLesson();
		if(nextLesson != null) {
			System.out.println(nextLesson.getRoomLesson().getName());
			System.out.println(nextLesson.getSubjectLesson().getName());
		}
		
	}
	
	public void estimateOccupationRoom() {
		//in lavorazione..
	}
	
	public void occupateSeat(Seat seatToOccupy) {
		seatToOccupy.occupateSeat();
	}
}