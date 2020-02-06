package logic.controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Vector;

import logic.model.DateApi;
import logic.model.Lesson;
import logic.model.Dao.LessonDao;

public class ViewNextLessonController {
	
	private Lesson nextLesson;
	private DateApi hourApi;
	
	
	public Lesson getNextLesson() throws SQLException {
		hourApi = new DateApi();
		Vector<Integer> actualHour = hourApi.getActualHour();
		
		//Conversion to seconds
		int seconds = actualHour.get(0)*60*60 + actualHour.get(1) * 60 + actualHour.get(2);
		
		//Query by db
		
		//nextLesson = LessonDao.findNextLesson(seconds);
		//System.out.println(nextLesson.getDayOfWeek());
		return nextLesson;
	}

}
