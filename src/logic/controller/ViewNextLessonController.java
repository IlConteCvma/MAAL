package logic.controller;

import java.time.*;

public class ViewNextLessonController {

	private Lesson nextLesson;
	private LocalTime date;
	
	public Lesson getNextLesson() {
		return nextLesson;
	}
	
	public int[] getActualHour() {
		GregorianCalendar dataAttuale=new GregorianCalendar();
		int ore = dataAttuale.get(GregorianCalendar.HOUR);
		int minuti = dataAttuale.get(GregorianCalendar.MINUTE);
		int secondi = dataAttuale.get(GregorianCalendar.SECOND);
		int oraEsatta[] = new int[3];
		oraEsatta[0] = ore;
		oraEsatta[1] = minuti;
		oraEsatta[2] = secondi;
		return oraEsatta;
	}

}
