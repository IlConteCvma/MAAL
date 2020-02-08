package logic.model;

import java.util.Vector;

public class Room {
	
	private String name;
	private int numRow;
	private int numColumn;
	private Vector<Seat> places;
	
	public Room(String name, int numRow, int numColumn, Vector<Seat>places) {
		this.name = name;
		this.numRow = numRow;
		this.numColumn = numColumn;
		this.places = places;
	}
	
	public Vector<Seat> getPlaces(){
		return this.places;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfFreePlaces() {
		int numberOfFreePlaces = 0;
		for(int i=0;i<numRow*numColumn;i++) {
			if(places.get(i).getState() == false) {
				numberOfFreePlaces++;
			}
		}
		return numberOfFreePlaces;
	}
}
