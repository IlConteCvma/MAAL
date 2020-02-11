package logic.bean;

import logic.model.Journey;
import logic.model.Lesson;

public class TimeToExitBean {
	
	private Lesson nextLesson;
	private Journey nextJourney;
	private double minuteToExit;
	private int priority;
	
	public Lesson getNextLesson() {
		return nextLesson;
	}

	public void setNextLesson(Lesson nextLesson) {
		this.nextLesson = nextLesson;
	}

	public Journey getNextJourney() {
		return nextJourney;
	}

	public void setNextJourney(Journey nextJourney) {
		this.nextJourney = nextJourney;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getMinuteToExit() {
		return minuteToExit;
	}

	public void setMinuteToExit(double minuteToExit) {
		this.minuteToExit = minuteToExit;
	}
	
}
