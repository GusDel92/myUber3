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
		for (PoolRequest existingRequest : currentRequests) {
			while (ride.getStatus()!="unconfirmed") {existingRequest.addRide(ride);
			existingRequest.proposeRequestToDrivers(existingRequest);
			} //on essaie de mettre la ride dans une request existante; il peut y avoir un pb de thread si un driver accepte la request au moment o� une ride s'y ajoute. Solution: n'envoyer que les Request "compl�tes" (soit 4 personnes soit 3 Ride dedans). Facile � faire, il suffit de modifier cete m�thode.
		if (ride.getStatus()!="unconfirmed") {
			PoolRequest nouvelleRequest=createRequest(ride);
			nouvelleRequest.proposeRequestToDrivers(nouvelleRequest);
			} //si la ride n'a pas trouv� de place dans les request existantes, on en cr�e une nouvelle.
		}
	}
	
}
