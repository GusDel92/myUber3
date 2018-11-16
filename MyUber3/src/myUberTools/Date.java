package myUberTools;

import java.util.GregorianCalendar;


public class Date {
	java.util.GregorianCalendar calendar = new GregorianCalendar();
	int heure = calendar.get(java.util.Calendar.HOUR_OF_DAY);
	int minute = calendar.get(java.util.Calendar.MINUTE);
	
	//donne l'heure en entier naturel; voir classe "Traffic" pour le static
	public static int getHour() {
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		return calendar.get(java.util.Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute() {
		java.util.GregorianCalendar calendar = new GregorianCalendar();
		return calendar.get(java.util.Calendar.MINUTE);
	}
}


