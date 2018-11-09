package myUberRide;

import java.util.ArrayList;
import myUberTools.Coordinates;

public class RideFactory {
	
	ArrayList<String> typeOfRides = new ArrayList<String>();
	
	//Constructeur de la RideFactory; à lancer dans le main au tout début.
	public RideFactory() {
		typeOfRides.add("uberX");
		typeOfRides.add("uberVan");
		typeOfRides.add("uberBlack");
		typeOfRides.add("uberPool");
	}

	
	//public static ArrayList<String> getTypeOfRides() {
	//	return typeOfRides;
	//}



	public Ride createRide(String rideType, Coordinates departure, Coordinates destination, String traffic) {
		if (rideType==null) {return null;}
		if (rideType.equalsIgnoreCase("UBERX")) {return new UberX(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERVAN")) {return new UberVan(departure, destination, traffic);}
		if (rideType.equalsIgnoreCase("UBERBLACK")) {return new UberBlack(departure, destination, traffic);}
		return null;
	}
}
