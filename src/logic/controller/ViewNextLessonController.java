package logic.controller;

import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.Vector;

import logic.model.Lesson;

public class ViewNextLessonController {
	private Lesson nextLesson;
	private LocalTime date;
	
	public Lesson getNextLesson() {
		return nextLesson;
	}

}
