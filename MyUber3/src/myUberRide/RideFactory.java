package myUberRide;

import myUberTools.Coordinates;

public class RideFactory {
	
	public Ride createRide(String rideType, Coordinates departure, Coordinates destination, String traffic) {
		if (rideType==null) {return null;}
		if (rideType.equalsIgnoreCase("UBERX")) {return new UberX(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERVAN")) {return new UberVan(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERBLACK")) {return new UberBlack(departure, destination, traffic);}
		return null;
	}
}
