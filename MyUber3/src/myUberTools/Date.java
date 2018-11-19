package myUberTools;

import java.util.GregorianCalendar;


/**
 * A useful tool to calculate the date of departure for a ride. Based on the Gregorian calendar.
 * @author Cuignet & Thiébaud
 *
 */
public class Date {
	java.util.GregorianCalendar calendar = new GregorianCalendar();
	int heure = calendar.get(java.util.Calendar.HOUR_OF_DAY);
	int minute = calendar.get(java.util.Calendar.MINUTE);
	
	
	public static int getHour() {
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		return calendar.get(java.util.Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute() {
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		return calendar.get(java.util.Calendar.MINUTE);
	}
}


