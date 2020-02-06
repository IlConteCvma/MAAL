package logic.model;

public class Seat {
	private boolean busy;
	private int index;
	
	private Seat(int index) {
		this.index = index;
		busy = false;
	}
	
	public void occupateSeat() {
		busy = true;
	}
	
	public void freeSeat() {
		busy = false;
	}
	
	public boolean getState() {
		return busy;
	}
}
