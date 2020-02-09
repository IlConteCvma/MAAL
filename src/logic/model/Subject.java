 package logic.model;

public class Subject {
	private String name;
	private double indexOfStudents;
	
	public Subject(String name, double index) {
		this.name = name;
		this.indexOfStudents = index;
	}
	
	public double getIndexOfStudents() {
		return this.indexOfStudents;
	}
	
	public String getName() {
		return this.name;
	}
}
