package myUberStatistics;


import java.util.ArrayList;

import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberRide.Ride;

public class MyUberBookOfRides {
        
	public static ArrayList<String> myUberBookOfRides;
	
	public MyUberBookOfRides(ArrayList<String> myUberBookOfRides) {
		this.myUberBookOfRides = myUberBookOfRides;
	}



	public ArrayList<String> getMyUberBookOfRides() {
		return myUberBookOfRides;
	}



	public void setMyUberBookOfRides(ArrayList<String> myUberBookOfRides) {
		this.myUberBookOfRides = myUberBookOfRides;
	}



	public static void addRideToTheBook(Ride ride){
		myUberBookOfRides.add("Customer " + Integer.toString(ride.getCustomer().getCustomerID())+ " ; Driver : "+Integer.toString(ride.getDriver().getDriverID())+ " ; Car : " + Integer.toString(ride.getCar().getCarID())+ " ; Departure : ("+Double.toString(ride.getDeparture().getLatitude())+", "+Double.toString(ride.getDeparture().getLongitude())+ ") ; Destination : ("+Double.toString(ride.getDestination().getLatitude())+", "+Double.toString(ride.getDestination().getLongitude())+") ; Length : "+ Double.toString(ride.getLength())+" ; Duration : " +ride.getDuration());
			
	}
	
	

}