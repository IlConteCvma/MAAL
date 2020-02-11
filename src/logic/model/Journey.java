package logic.model;

import java.util.Vector;

public class Journey {

	private Vector<Double> originAddress;
	private Vector<Double> destinationAddress;
	private Double distance;
	private int lateForWeather;
	
	public Journey(Vector<Double> originAddress) {
		this.setOriginAddress(originAddress);
		//Set destination address with data of University Of Tor Vergata
		this.destinationAddress = new Vector<Double>(2);
		this.destinationAddress.add(41.85);
		this.destinationAddress.add(12.63);
		lateForWeather = 0;
	}

	public Vector<Double> getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(Vector<Double> originAddress) {
		this.originAddress = originAddress;
	}
	
	public Vector<Double> getDestinationAddress() {
		return destinationAddress;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public int getLateForWeather() {
		return lateForWeather;
	}

	public void setLateForWeather(int lateForWeather) {
		this.lateForWeather = lateForWeather;
	}
	
}
