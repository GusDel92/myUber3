package myUberRide;

import java.util.ArrayList;

public class PoolRequests {
	static ArrayList<PoolRequest> currentRequests = new ArrayList<PoolRequest>();
	private static PoolRequests instance = new PoolRequests();
	
	public static PoolRequests getInstance(){
			
			return instance;
	}
	
	public static PoolRequest createRequest(Ride ride) {
		PoolRequest request = new PoolRequest();
		currentRequests.add(request);
		request.ridesOfTheRequest.add(ride);
		return request;
	}
	
	public void deleteRequest(PoolRequest request) {
		PoolRequests.currentRequests.remove(request);
	}
	
	public static void manageNewRide(Ride ride) {
		for (PoolRequest request : currentRequests) {
			while (ride.getStatus()!="unconfirmed") {request.addRide(ride);
			request.proposeRequestToDrivers(request);
			} //on essaie de mettre la ride dans une request existante
		if (ride.getStatus()!="unconfirmed") {createRequest(ride);
		ride.request=createRequest(ride);} //si la ride n'a pas trouvé de place dans les request existantes, on en crée une nouvelle.
		}
	}
	
}
