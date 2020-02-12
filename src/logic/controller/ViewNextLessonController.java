package logic.controller;

import logic.model.Lesson;
import logic.model.dao.NextLessonDao;

public class ViewNextLessonController {
	
	private NextLessonDao nextLessonDao;
	private Lesson nextLesson;
	
	public Lesson getNextLesson() {
		nextLessonDao = new NextLessonDao();
		nextLesson = nextLessonDao.getNextLesson();
		return nextLesson;
	}

}
