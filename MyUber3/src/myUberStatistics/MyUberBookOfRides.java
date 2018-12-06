package myUberStatistics;


import java.util.ArrayList;
import myUberRide.Ride;

public class MyUberBookOfRides {
        
public ArrayList<String> myUberBookOfRides = new ArrayList<String>();
	
private static MyUberBookOfRides instance = new MyUberBookOfRides();
	
	public static MyUberBookOfRides getInstance(){
			
			return instance;}



	public ArrayList<String> getMyUberBookOfRides() {
		return myUberBookOfRides;
	}



	public void setMyUberBookOfRides(ArrayList<String> myUberBookOfRides) {
		this.myUberBookOfRides = myUberBookOfRides;
	}



	public static void addRideToTheBook(Ride ride){
		getInstance().myUberBookOfRides.add("Customer " + ride.getCustomer().getCustomerID()); //+ " ; Driver : "+Integer.toString(ride.getDriver().getDriverID()) + " ; Car : " + ride.getCar().getCarID() + " ; Departure : ("+Double.toString(ride.getDeparture().getLatitude())+", "+Double.toString(ride.getDeparture().getLongitude())+ ") ; Destination : ("+Double.toString(ride.getDestination().getLatitude())+", "+Double.toString(ride.getDestination().getLongitude())+") ; Length : "+ Double.toString(ride.getLength())+" ; Duration : " +ride.getDuration());
			
	}
	
	

}