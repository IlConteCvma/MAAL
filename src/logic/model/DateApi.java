package logic.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

public class DateApi{

	public Vector<Integer> getActualHour() {
		GregorianCalendar dataAttuale=new GregorianCalendar();
		int ore = dataAttuale.get(Calendar.HOUR);
		int minuti = dataAttuale.get(Calendar.MINUTE);
		int secondi = dataAttuale.get(Calendar.SECOND);
		Vector<Integer> actualHour = new Vector<>();
		actualHour.add(ore);
		actualHour.add(minuti);
		actualHour.add(secondi);
		return actualHour;
	}
	
}
