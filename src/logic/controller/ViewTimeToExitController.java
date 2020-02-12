package logic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javafx.scene.Scene;
import logic.MainClass;
import logic.Session;
import logic.bean.SeatBean;
import logic.bean.TimeToExitBean;
import logic.model.Journey;
import logic.model.Lesson;
import logic.model.MapsApi;
import logic.model.TimeApi;
import logic.model.WeatherApi;
import logic.model.dao.SeatDao;
import logic.view.AlertControl;
import logic.view.HomeTimePage;
import logic.view.Page;
import logic.view.graphic.controller.TimeToExitGraphicController;

public class ViewTimeToExitController {
	
	//const value
	private final static int weight = 50;
	private final static int minuteOfAdvance = 15;
	private final static double percentDistanceAdd = 0.14;
	
	//association attribute
	private ViewNextLessonController nextLessonController = new ViewNextLessonController();
	private TimeToExitGraphicController timeToExitController;
	private TimeApi time;
	private MapsApi map;
	private WeatherApi weather;
	private Journey nextJourney;
	private TimeToExitBean timeToExitBean;
	
	public void getInfoByMaps(){
		this.map = new MapsApi();
		//Calculate latitude and longitude 
		try {
			nextJourney = new Journey(this.map.getPosition(Session.getSession().getStudent().getAddress()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Calculate distance in km
		nextJourney.setDistance(this.map.calculateDistance(nextJourney.getOriginAddress(),nextJourney.getDestinationAddress()));
	}
	
	public void getInfoByWeather(){
		this.weather = new WeatherApi();
		String rainIntensity = null;
		try {
			rainIntensity = weather.getRainIntensity();
		} catch (IOException e) {
				e.printStackTrace();
		}
		if(rainIntensity.equals("Light")) {
			nextJourney.setLateForWeather(5);
		}else if(rainIntensity.equals("Moderate")){
			nextJourney.setLateForWeather(10);
		}
	}
	
	public void estimateTimeToExit() throws IOException{
		Lesson nextLesson = nextLessonController.getNextLesson();
		if(nextLesson != null) {
			time = new TimeApi();
			timeToExitBean = new TimeToExitBean();
			timeToExitBean.setNextLesson(nextLesson);
			double speedAverage = Session.getSession().getStudent().getVehicle().getSpeed();
			getInfoByMaps();
			getInfoByWeather();
			nextJourney.setDistance(nextJourney.getDistance() + percentDistanceAdd * nextJourney.getDistance()); //add 14% -> value take by test
			double minutes = (int) ((nextJourney.getDistance() / (speedAverage*0.016))) + nextJourney.getDistance() + minuteOfAdvance;
			long timeExit = time.getTimeMinuteDiff(nextLesson.getStartHour().toString(), time.getStringHour(time.getCurrentDate()));
			int i = 0;
			double timeToExit = 0;
			do {
				timeToExit = (int) (timeExit - (minutes + calculateTimeBasedOccupationRoom(i)));
				i++;
			}while(timeToExit<0 && i < 3);
			if(timeToExit < 0) {
				AlertControl.infoBox("E' troppo tardi!", "WARNING");
				timeToExit = 0;
			}else {
				timeToExitBean.setMinuteToExit(timeToExit);
				timeToExitBean.setPriority(i);
				timeToExitBean.setNextJourney(nextJourney);
				timeToExitBean.setNextLesson(nextLesson);
				timeToExitController = new TimeToExitGraphicController(timeToExitBean);
				Page root = new HomeTimePage(timeToExitBean);
				Scene scene = new Scene(root);
				MainClass.getStage().setScene(scene);
			}
		}else {
			AlertControl.infoBox("You have not lesson today", "NOT LESSON");
		}
	}
	
	public double calculateTimeBasedOccupationRoom(int priority) {
		int freePlaces = timeToExitBean.getNextLesson().getRoomLesson().getNumberOfFreePlacesForPriority(priority);
		Vector<Integer> range = timeToExitBean.getNextLesson().getRoomLesson().getSeatOfPriority(priority);
		int allPlaces = range.get(1) - range.get(0);
		int busyPlaces = allPlaces - freePlaces;
		double minute = weight * timeToExitBean.getNextLesson().getSubjectLesson().getIndexOfStudents() * (busyPlaces/allPlaces);
		return minute;
	}
	
	public void occupateSeat(SeatBean seat) {
		SeatDao seatDao = new SeatDao();
		try {
			seatDao.occupySeat(seat.getRoom().getName(), seat.getIndex()+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}