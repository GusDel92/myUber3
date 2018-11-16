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
		ride.setStatus("unconfirmed");
		request.setStatus("unconfirmed");
		return request;
	}
	
	public static void deleteRequest(PoolRequest request) {
		PoolRequests.currentRequests.remove(request);
	}
	
	//on essaie de mettre la ride dans une request existante; il peut y avoir un pb de thread si un driver accepte la request au moment où une ride s'y ajoute. Solution: n'envoyer que les Request "complètes" (soit 4 personnes soit 3 Ride dedans). Facile à faire, il suffit de modifier cete méthode.
	public static void manageNewRide(UberPool ride) {
		ride.setStatus("not yet unconfirmed");
		//int n=currentRequests.size();
		for (PoolRequest existingRequest : currentRequests) {
		//for (int i=0;i<=n-1;i++) {
			//while (ride.getStatus()!="unconfirmed") {
			//PoolRequest existingRequest = currentRequests.get(i);
			if (existingRequest.addRide(ride)==true){
			ride.setRequest(existingRequest);
			existingRequest.proposeRequestToDrivers();
			}
		}
		if (ride.getStatus()!="unconfirmed") {
			PoolRequest nouvelleRequest=createRequest(ride);
			ride.setRequest(nouvelleRequest);
			nouvelleRequest.proposeRequestToDrivers();
			} //si la ride n'a pas trouvé de place dans les request existantes, on en crée une nouvelle.
		}
}
	

