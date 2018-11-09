package myUberRide;

import java.util.ArrayList;

import myUberCar.Car;
import myUberCustomer.Customer;
import myUberTools.Coordinates;
import myUberTools.Traffic;

public abstract class Ride {

	private Coordinates departure;
	private Coordinates destination;
	protected String type;
	private double length;
	private String traffic;
	private double duration;
	private double price;
	public String status;
	//private Date startDate;
	//private Date endDate;
	private Car car;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	public int driverId;
	public double rate;
	
	
	public double basicRate;
	public double trafficRate;
	public double rateLengthInf5km;
	public double rateLength5To10km;
	public double rateLength10To20km;
	public double rateLengthSup20km;
	public double rateLowTraffic;
	public double rateMediumTraffic;
	public double rateHeavyTraffic;
	
	//faut-il ajouter en paramètre de cette méthode la date ?
	
	//pour comparer les prix il faut avoir le même traffic sur tous les types de Ride; il faudrait alors le mettre en paramètre du constructeur (ou bien créer un nouveau constructeur?)
	//(suite de la ligne pcdte) mais alors il faut garder le même traffic entre la comparaison des prix et le prix de la course => le premier constructeur est en fait inutile !
	//public Ride(Coordinates departure, Coordinates destination) {
		//donner l'h
		
		//en déduire le traffic
		//this.traffic=getTraffic(startDate);
		//calculer la longueur
		//computeLength(this);
		//en déduire la durée
		//computeDuration(this);
	//}
	
	public Ride(Coordinates departure, Coordinates destination, String traffic) {
		this.traffic=traffic;
		//calculer la longueur
		computeLength(this);
		//en déduire la durée
		computeDuration(this);
	}

	
	private void computeLength(Ride ride) {
		ride.length=Math.sqrt(Math.pow(ride.departure.latitude-ride.destination.latitude, 2)+Math.pow(ride.departure.longitude-ride.destination.longitude,2));
		
	}

	public void addCustomer(Ride ride, Customer customer) {
		ride.customers.add(customer);
	}

	//this function returns the duration of the ride in minutes (length must be given in km)
	//on peut rajouter un catch error pour le cas où le traffic ou la longueur de la course n'est pas encore entré
	public void computeDuration(Ride ride) {
		if (ride.traffic=="low-traffic") {ride.duration=ride.length/15*60;}
		else if (ride.traffic=="medium-traffic") {ride.duration=ride.length/7.5*60;}
		else if (ride.traffic=="heavy-traffic") {ride.duration=ride.length/3*60;}
	}
	
	public void computePrice(Ride ride) {
		//on détermine le trafficRate
		if (ride.traffic=="low-traffic") {ride.trafficRate=ride.rateLowTraffic;}
		else if (ride.traffic=="medium-traffic") {ride.trafficRate=ride.rateMediumTraffic;}
		else if (ride.traffic=="heavy-traffic") {ride.trafficRate=ride.rateHeavyTraffic;}
		//on détermine le basicRate
		if (ride.length<=5) {ride.basicRate=ride.rateLengthInf5km;}
		else if (ride.length>5 & ride.length<=10) {ride.basicRate=ride.rateLength5To10km;}
		else if (ride.length>10 & ride.length<=20) {ride.basicRate=ride.rateLength10To20km;}
		else if (ride.length>20) {ride.basicRate=ride.rateLengthSup20km;}
		//on donne le prix
		ride.price=ride.basicRate*ride.length*ride.trafficRate;
	}
	
	//cette méthode a-t-elle sa place ici ?
	//ajouter dans le main une liste des string de classes concrètes de rides dispos, créer une instance de chaque ride avec juste les coordonnées de départ et d'arrivée et le même traffic; cela est possible seulement si on calcule le traffic avant d'instancier les différentes rides.
	//en améliorant la factory (abstract factory?) on peut faire en sorte que cette liste grandisse toute seule quand on crée une nouvelle sous classe de Ride
	public void comparePrices(Coordinates departure, Coordinates destination) {
		Traffic traf = new Traffic();
		this.traffic=traf.getTraffic();
		//for (String typeOfRide : RideFactory.getTypeOfRides()) {
			//ride=RideFactory.createRide(typeOfRide, departure, destination, traffic);
			//computePrice(ride);
		//	System.out.println("The price for an"+typeDeRide+"ride is"+ride.price+"€.");
			 
		}

		
//	}
	
	//prochaine méthode totalement inutile en fait je pense
	//quand une course est lancée, elle n'accepte plus de nouveau client, sauf pour le UberPool où cette méthode est Override.
	public boolean acceptCustomer() {
		return false;
	};
	
}
