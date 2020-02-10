package logic.controller;

import java.io.IOException;
import java.util.Vector;

import logic.Session;
import logic.model.Lesson;
import logic.model.MapsApi;
import logic.model.Seat;
import logic.model.SingletonConnectionDB;
import logic.model.TimeApi;
import logic.model.WeatherApi;
import logic.view.AlertControl;

public class ViewTimeToExitController {
	
	private final int weight = 50;
	private final int minuteOfAdvance = 15;
	
	private Lesson nextLesson;
	private ViewNextLessonController nextLessonController = new ViewNextLessonController();
	private TimeApi time = new TimeApi();
	private MapsApi map;
	private WeatherApi weather;
	private Vector<Double> originAddress;
	private Vector<Double> destinationAddress;
	private Double distance;
	private int lateForWeather = 0;
	private int minutes;
	private int timeToExit;
	
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
			this.originAddress= this.map.getPosition(Session.getSession().getStudent().getAddress());
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
			this.lateForWeather = 5;
		}else if(rainIntensity.equals("Moderate")){
			this.lateForWeather = 10;
		}
	}
	
	public void estimateTimeToExit(){
		if(nextLesson != null) {
			double speedAverage = Session.getSession().getStudent().getVehicle().getSpeed();
			getInfoByMaps();
			this.distance = this.distance + 0.14 * this.distance; //add 14% -> value take by test
			this.minutes = (int) ((this.distance / (speedAverage*0.016))) + this.lateForWeather + minuteOfAdvance;
			long timeExit = time.getTimeMinuteDiff(nextLesson.getStartHour().toString(), time.getStringHour(time.getCurrentDate()));
			int i = 0;
			do {
				timeToExit = (int) (timeExit - (this.minutes + calculateTimeBasedOccupationRoom(i)));
				i++;
			}while(timeToExit<0 && i < 3);
			if(timeToExit <0) {
				AlertControl.infoBox("E' troppo tardi!", "WARNING");
			}else {
				System.out.println("Esci di casa fra "+ timeToExit +" minuti per la "+i+" fascia");
			}
		}
	}
	
	public void getNextLesson(){
		nextLesson = null;
		nextLesson = nextLessonController.getNextLesson();
		if(nextLesson != null) {
			estimateTimeToExit();
		}else {
			AlertControl.infoBox("You have not lesson today", "NOT LESSON");
		}
	 }
	
	public double calculateTimeBasedOccupationRoom(int priority) {
		int freePlaces = nextLesson.getRoomLesson().getNumberOfFreePlacesForPriority(priority);
		Vector<Integer> range = nextLesson.getRoomLesson().getSeatOfPriority(priority);
		int allPlaces = range.get(1) - range.get(0);
		int busyPlaces = allPlaces - freePlaces;
		double minute = weight * nextLesson.getSubjectLesson().getIndexOfStudents() * (busyPlaces/allPlaces);
		return minute;
	}
	
	public void occupateSeat(Seat seatToOccupy) {
		seatToOccupy.occupateSeat();
	}
}