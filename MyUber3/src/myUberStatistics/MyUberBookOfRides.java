package myUberStatistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberRide.Ride;

public class MyUberBookOfRides {
        
	private static File myUberBookOfRides = new File("myUberBookOfRides");
	
	private static MyUberBookOfRides instance = new MyUberBookOfRides();
	
	public static MyUberBookOfRides getInstance(){
			
			return instance;
			}
	
	
	
	public static void addRideToTheBook(Ride ride){
		FileWriter writer;
		try {
		writer = new FileWriter("myUberBookOfRides");
		writer.write("Customer ID : "+ride.getCustomer().getCustomerID()+"\n"+"Driver ID : "+ride.getDriver().getDriverID()+"\n" + "Trajectory - pick up point : " + ride.getDeparture()+ "drop off point : "+ride.getDestination()+ "\n"+"Length : "+ride.getLength()+ " km"+"\n"+"Duration : "+ride.getDuration().getSeconds()/60+"minutes \n"+"\n");
        writer.close();}
		catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
}