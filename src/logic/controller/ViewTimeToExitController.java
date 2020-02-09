package logic.controller;

import java.io.IOException;
import java.util.Vector;
import logic.AlertControl;
import logic.bean.StudentBean;
import logic.model.Lesson;
import logic.model.MapsApi;
import logic.model.Seat;
import logic.model.SingletonConnectionDB;
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
	
	public void getInfoByMaps(){
		this.map = new MapsApi();
		//Calculate latitude and longitude 
		try {
			this.originAddress= this.map.getPosition(SingletonConnectionDB.getStudent().getAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDestinationAddress();
		//Calculate distance in km
		this.distance = this.map.calculateDistance(originAddress,destinationAddress);
	}
	
	public void getInfoByMeteo(){
		this.weather = new WeatherApi();
		String rainIntensity = null;
		try {
			rainIntensity = weather.getRainIntensity();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(rainIntensity.equals("Light")) {
			this.lateForWeather = 5.0;
		}else if(rainIntensity.equals("Moderate")){
			this.lateForWeather = 10.0;
		}
	}
	
	public void estimateTimeToExit(StudentBean studLog){
		getNextLesson();
		if(nextLesson != null) {
			double speedAverage = SingletonConnectionDB.getStudent().getVehicle().getSpeed();
			getInfoByMaps();
			this.distance = this.distance + 0.14 * this.distance; //add 14% -> value take by test
			this.minutes = (this.distance / (speedAverage*0.016)) + this.lateForWeather;
			System.out.println("Ci metterai orientativamente "+this.minutes);
		}else {
			AlertControl.infoBox("You have not lesson today", "NOT LESSON");
		}
	}
	
	public void getNextLesson(){
		nextLesson = nextLessonController.getNextLesson();
		if(nextLesson != null) {
			System.out.println(nextLesson.getSubjectLesson().getName());
			System.out.println("Free places: "+nextLesson.getRoomLesson().getNumberOfFreePlaces()+"/"+nextLesson.getRoomLesson().getNumberOfPlaces());
		}
		
	}
	
	public void calculateTimeBasedOccupationRoom() {
		
	}
	
	public void occupateSeat(Seat seatToOccupy) {
		seatToOccupy.occupateSeat();
	}
}