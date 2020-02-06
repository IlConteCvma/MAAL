package logic.model;

public class Lesson {
	
	private double startHour;
	private double endHour;
	private int dayOfWeek;
	private Room roomLesson;
	private Subject subjectLesson;
	
	public Lesson(int startHour, int endHour, int dayOfWeek, Room roomLesson, Subject subjectLesson) {
		this.startHour = startHour;
		this.endHour = endHour;
		this.dayOfWeek = dayOfWeek;	
		this.roomLesson = roomLesson;
		this.subjectLesson = subjectLesson;
	}
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	
	public Room getRoomLesson() {
		return this.roomLesson;
	}
	
	public Subject getSubjectLesson() {
		return subjectLesson;
	}
}
