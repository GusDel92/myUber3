package myUberRide;

import java.util.ArrayList;

public class PoolRequest {
	
	ArrayList<Ride> ridesOfTheRequest=new ArrayList<Ride>();
	private int totalNbrOfPassengers;
	
	public void addRide(Ride ride) {
		if (this.ridesOfTheRequest.size()<=3 & this.totalNbrOfPassengers+ride.getNbrOfPassengers()<=4) {  //On peut mettre 9 si on considère qu'un van peut faire uberPool. Pas hyper utile et ça complique pas mal.
			ridesOfTheRequest.add(ride);
			this.totalNbrOfPassengers=this.totalNbrOfPassengers+ride.getNbrOfPassengers();
			ride.status="unconfirmed";
		}
		else {return;}
	}
	
}
