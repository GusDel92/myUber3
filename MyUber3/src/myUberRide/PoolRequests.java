package myUberRide;

import myUberDriver.Driver;
import myUberDriver.Drivers;
import java.util.ArrayList;

public class PoolRequests {
	private PoolRequest notFilledRequest;
	ArrayList<PoolRequest> currentRequests = new ArrayList<PoolRequest>();
	private static PoolRequests instance = new PoolRequests();
	
	public static PoolRequests getInstance(){
			
			return instance;
	}
	
	public void createRequest(Ride ride) {
		PoolRequest request = new PoolRequest();
		this.currentRequests.add(request);
		request.ridesOfTheRequest.add(ride);
	}
	
	public void deleteRequest(PoolRequest request) {
		this.currentRequests.remove(request);
	}
	
	public void manageNewRide(Ride ride) {
		for (PoolRequest request : currentRequests) {
			while (ride.getStatus()!="unconfirmed") {request.addRide(ride);} //on essaie de mettre la ride dans une request existante
		if (ride.getStatus()!="unconfirmed") {createRequest(ride);} //si la ride n'a pas trouvé de place dans les request existantes, on en crée une nouvelle.
		}
	}
	
}
