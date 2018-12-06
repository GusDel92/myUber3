package myUberRide;

import java.util.ArrayList;

public class PoolRequests {
	private ArrayList<PoolRequest> currentRequests = new ArrayList<PoolRequest>();
	private static PoolRequests instance = new PoolRequests();
	
	public static PoolRequests getInstance(){
			
			return instance;
	}
	
	public PoolRequest createRequest(Ride ride) {
		PoolRequest request = new PoolRequest();
		currentRequests.add(request);
		request.ridesOfTheRequest.add(ride);
		ride.setStatus("unconfirmed");
		request.setStatus("unconfirmed");
		return request;
	}
	
	public void deleteRequest(PoolRequest request) {
		PoolRequests.getInstance().currentRequests.remove(request);
	}
	
	//on essaie de mettre la ride dans une request existante
	public void manageNewRide(UberPool ride) {
		ride.setStatus("not yet unconfirmed");
		for (PoolRequest existingRequest : PoolRequests.getInstance().currentRequests) {
			if (existingRequest.addRide(ride)==true){
			ride.setRequest(existingRequest);
			}
			if (existingRequest.getRidesOfTheRequest().size()==3 || existingRequest.getTotalNbrOfPassengers()==4) {
				existingRequest.proposeRequestToDrivers();
				break;
				}
		}
		if (ride.getStatus()!="unconfirmed") {
			PoolRequest nouvelleRequest=PoolRequests.getInstance().createRequest(ride);
			ride.setRequest(nouvelleRequest);
			} //si la ride n'a pas trouvé de place dans les request existantes, on en crée une nouvelle.
		}
}
	

