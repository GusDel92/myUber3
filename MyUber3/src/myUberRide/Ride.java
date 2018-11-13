package myUberRide;

import java.util.ArrayList;
import java.util.Scanner;

import myUberCar.Car;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberTools.Coordinates;
import myUberTools.Traffic;

public abstract class Ride {

	private Coordinates departure;
	private Coordinates destination;
	protected String type;
	private int nbrOfPassengers;
	private double length;
	private Traffic traffic;
	private double duration;
	private double price;
	protected ArrayList<Driver> potentialDrivers = new ArrayList<Driver>();
	public String status;
	//private Date startDate;
	//private Date endDate;
	private Car car;
	private Customer customer;
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
	public PoolRequest request;
	
	public Ride(Coordinates departure, Coordinates destination, Traffic traffic) {
		this.traffic=traffic;
		//calculer la longueur
		computeLength(this);
		//en déduire la durée
		computeDuration(this);
	}
	
	public int getNbrOfPassengers() {
		return nbrOfPassengers;
	}

	public void setNbrOfPassengers(int nbrOfPassengers) {
		this.nbrOfPassengers = nbrOfPassengers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ArrayList<Driver> getPotentialDrivers() {
		return potentialDrivers;
	}

	public void setPotentialDrivers(ArrayList<Driver> potentialDrivers) {
		this.potentialDrivers = potentialDrivers;
	}

	private void computeLength(Ride ride) {
		ride.length=Math.sqrt(Math.pow(ride.departure.getLatitude()-ride.destination.getLatitude(), 2)+Math.pow(ride.departure.getLongitude()-ride.destination.getLongitude(),2));
		
	}

	public Customer getCustomer() {
		return this.customer;
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
	//ajouter dans le main une liste des string de classes concrètes de rides dispos, créer une instance de chaque ride avec juste les coordonnées de départ et d'arrivée et le même traffic; cela est possible seulement si on calcule le traffic avant d'instancier les différentes rides.
	//en améliorant la factory (abstract factory?) on peut faire en sorte que cette liste grandisse toute seule quand on crée une nouvelle sous classe de Ride

	public double getPrice() {
		return price;
	}
	
	//public Car getClosestCarFromDeparture(){
		//ArrayList<Car> carsWhoDeclined = new ArrayList<Car>();
		//trier les voitures par ordre de proximitié avec le point (méthode en doc texte sur mon bureau)
		//
	//	for (Driver availableDriver : Drivers.getOnDutyDrivers()) {
		//	if (driversWhoDeclined.contains(availableDriver)==false) {
				
		//	}
	//	}
		
		//return null;
	//}
	
	public void proposeRideToDrivers() {
		while (this.status=="unconfirmed") {	
			for (Driver potentialDriver : this.potentialDrivers) {
				if (potentialDriver.getState()=="on-duty") {
					Scanner sc = new Scanner(System.in);
					System.out.println(potentialDriver.getName()+" do you want to take a "+this.type+" ride from"+this.departure.getLatitude()+", "+this.departure.getLongitude()+" to "+this.destination.getLatitude()+", "+this.destination.getLongitude()+" ?");
					String answer = sc.next();
					if (answer.equalsIgnoreCase("yes")){
						this.driver=potentialDriver;
						this.status="confirmed";
						this.car=this.driver.getActualCar();
						this.driver.setState("on-a-ride");
						this.manageRide();
					sc.close();
					}
					
				}
			}
			System.out.println("There is no available driver for your ride. Please try again.");
			//supprimer la ride
		}	
	}

	public void manageRide() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Client"+this.customer.getSurname()+"récupéré ?");
		String answer = sc.next();
		if (answer=="yes") {
			this.setStatus("ongoing");
			System.out.println("Course terminée ?");
			String answer2 = sc.next();
			if (answer2=="yes") {this.setStatus("completed");}
			}
		
		sc.close();
	}
	
}
