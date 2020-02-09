package logic.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

public class TimeApi {
	
	public Date getCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
	
	public String getStringHour(Date date) {
		String dateString = date.toString();
		String dateParsed = ""+dateString.charAt(11)+dateString.charAt(12)+dateString.charAt(13)+dateString.charAt(14)+dateString.charAt(15)+dateString.charAt(16)+dateString.charAt(17)+dateString.charAt(18);
		return dateParsed;
	}
	
	public long getTimeMinuteDiff(String time1, String time2) {
		    LocalTime t1 = LocalTime.parse(time1);
		    LocalTime t2 = LocalTime.parse(time2);
		    Duration diff = Duration.between(t2, t1);
		    return diff.toMinutes();
	}
	
}
