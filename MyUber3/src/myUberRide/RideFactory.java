package myUberRide;

import java.util.ArrayList;

import myUberTools.Coordinates;
import myUberTools.Traffic;

public class RideFactory {
	
	ArrayList<String> typeOfRides = new ArrayList<String>();
	
	private static RideFactory instance = new RideFactory();
	
	public static RideFactory getInstance(){
			
			return instance;
	}
	public RideFactory() {
		typeOfRides.add("uberX");
		typeOfRides.add("uberVan");
		typeOfRides.add("uberBlack");
		typeOfRides.add("uberPool");
	}

	
	public ArrayList<String> getTypeOfRides() {
		return typeOfRides;
	}

	public static Ride createRide(String rideType, Coordinates departure, Coordinates destination, Traffic traffic) {
		if (rideType==null) {return null;}
		if (rideType.equalsIgnoreCase("UBERX")) {return new UberX(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERVAN")) {return new UberVan(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERBLACK")) {return new UberBlack(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERPOOL")) {return new UberPool(departure, destination, traffic);}
		return null;
	}
}

