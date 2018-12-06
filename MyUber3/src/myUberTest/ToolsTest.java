package myUberTest;

import org.junit.Test;

import myUberTools.Coordinates;
import myUberTools.Date;
import myUberTools.Message;
import myUberTools.Traffic;

public class ToolsTest {
	
	@Test
	public void coordinatesTest(){
		Coordinates coord1 = new Coordinates(35, 41);
		Coordinates coord2 = new Coordinates(30, 43);
		System.out.println("The two following coordinates should be equals");
		System.out.println(coord1.distanceTo(coord2));
		System.out.println(coord2.distanceTo(coord1));}
	
	public void dateTest(){
		System.out.println(Date.getHour());
		System.out.println(Date.getMinute());}
		
	public void trafficTest(){
		System.out.println(new Traffic(5).getActualTraffic());
		System.out.println(new Traffic(6).getActualTraffic());
		System.out.println(new Traffic(9).getActualTraffic());
		System.out.println(new Traffic(12).getActualTraffic());
		System.out.println(new Traffic(17).getActualTraffic());
		System.out.println(new Traffic(19).getActualTraffic());
		System.out.println(new Traffic(22).getActualTraffic());}
	
	public void messageText(){
		Message msg1 = new Message("bonjour myUber");
		Message msg2 = new Message("mise à jour disponible");
		System.out.println(msg1.getMessageID());
		System.out.println(msg2.getMessageID());
		System.out.println(msg1.getText()+msg2.getText());
	}
	
}
