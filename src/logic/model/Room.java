package logic.model;

import java.util.Vector;

public class Room {
	
	private String name;
	private int numRow;
	private int numColumn;
	private Vector<Seat> places;
	
	public Room(String name, int numRow, int numColumn) {
		this.name = name;
		this.numRow = numRow;
		this.numColumn = numColumn;
	}
	
	public Room(String name, int numRow, int numColumn, Vector<Seat>places) {
		this.name = name;
		this.numRow = numRow;
		this.numColumn = numColumn;
		this.places = places;
	}
	
	public int getNumRow() {
		return numRow;
	}
	
	public int getNumColumn() {
		return numColumn;
	}
	
	public void setPlaces(Vector<Seat> places){
		this.places = places;
	}
	
	public Vector<Seat> getPlaces(){
		return this.places;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfPlaces() {
		int numberOfPlaces = numRow * numColumn;
		return numberOfPlaces;
	}
	
	public Vector<Integer> getSeatOfPriority(int priority) {
		//priority = 0(best), 1(good), 2(bad) 
		Vector<Integer> range = new Vector<Integer>(2);
		int startRange = (int) (priority * 0.334  * getNumberOfPlaces());
		int endRange = (int) ((priority+1) * 0.334  * getNumberOfPlaces());
		range.add(startRange);
		range.add(endRange);
		return range;
	}
	
	public int getNumberOfFreePlacesForPriority(int priority) {
		Vector<Integer> range = getSeatOfPriority(priority);
		int numberOfFreePlaces = 0;
		for(int i=range.get(0);i<range.get(1);i++) {
			if(places.get(i).getState() == false) {
				numberOfFreePlaces++;
			}
		}
		return numberOfFreePlaces;
	}
}
