package myUberStatistics;


import java.util.ArrayList;

import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberRide.Ride;

public class MyUberBookOfRides {
        
	private ArrayList<ArrayList<String>> myUberBookOfRides = new ArrayList<ArrayList<String>>();
 
	static MyUberBookOfRides instance = new MyUberBookOfRides();
	
	public static MyUberBookOfRides getInstance(){
			
			return instance;
			}
	
	public void addRideToTheBook(Ride ride){
		ArrayList<String> data = new ArrayList<String>();
		data.add("Customer " + Integer.toString(ride.getCustomer().getCustomerID())+ " ; Driver : "+Integer.toString(ride.getDriver().getDriverID())+ " ; Car : " + Integer.toString(ride.getCar().getCarID())+ " ; Departure : ("+Double.toString(ride.getDeparture().getLatitude())+", "+Double.toString(ride.getDeparture().getLongitude())+ ") ; Destination : ("+Double.toString(ride.getDestination().getLatitude())+", "+Double.toString(ride.getDestination().getLongitude())+") ; Length : "+ Double.toString(ride.getLength())+" ; Duration : " +Double.toString(ride.getDuration().toMinutes()));
		myUberBookOfRides.add(data);
		
	}
	
	

}