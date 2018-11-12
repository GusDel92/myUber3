package myUberRide;

import java.util.ArrayList;

import myUberCar.Car;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberTools.Coordinates;
import myUberTools.Traffic;

public abstract class Ride {

	private Coordinates departure;
	private Coordinates destination;
	protected String type;
	private int nbrPassengers;
	private double length;
	private Traffic traffic;
	private double duration;
	private double price;
	public String status;
	//private Date startDate;
	//private Date endDate;
	private Car car;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	public Driver driver;
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
	
	public Ride(Coordinates departure, Coordinates destination, Traffic traffic) {
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
		if (ride.traffic.getActualTraffic()=="low-traffic") {ride.duration=ride.length/15*60;}
		else if (ride.traffic.getActualTraffic()=="medium-traffic") {ride.duration=ride.length/7.5*60;}
		else if (ride.traffic.getActualTraffic()=="heavy-traffic") {ride.duration=ride.length/3*60;}
	}
	
	public void computePrice(Ride ride) {
		//on détermine le trafficRate
		if (ride.traffic.getActualTraffic()=="low-traffic") {ride.trafficRate=ride.rateLowTraffic;}
		else if (ride.traffic.getActualTraffic()=="medium-traffic") {ride.trafficRate=ride.rateMediumTraffic;}
		else if (ride.traffic.getActualTraffic()=="heavy-traffic") {ride.trafficRate=ride.rateHeavyTraffic;}
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
		this.traffic=traf;
		for (String typeOfRide : RideFactory.getTypeOfRides()) {
			Ride ride = RideFactory.createRide(typeOfRide, departure, destination, traffic);
			computePrice(ride);
			System.out.println("The price for an"+typeOfRide+"ride is"+ride.price+"€.");	 
		}	
	}
	
}
