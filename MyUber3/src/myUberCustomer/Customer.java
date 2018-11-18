package myUberCustomer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import myUberCar.Car;
import myUberRide.Ride;
import myUberRide.RideFactory;
import myUberTools.Coordinates;
import myUberTools.Message;
import myUberTools.Traffic;

public class Customer {

	private static int counter = 0;
	private int customerID;
	private int creditCardNbr;
	private String name;
	private String surname;
	private Coordinates coordinates;
    ArrayList<Message> messageBox = new ArrayList<Message>();
    ArrayList<Car> potentialCarsForActualRide = new ArrayList<Car>();
    ArrayList<Ride> potentialRideOrder = new ArrayList<Ride>();
    private Duration totalTimeSpentOnCar;
    private double totalAmountOfCashSpent;
    private int totalNumberOfRides;
    
	
	
	public Customer(String name, String surname) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.coordinates = new Coordinates();
		this.totalAmountOfCashSpent = 0;
		this.totalNumberOfRides=0;
		this.totalTimeSpentOnCar=Duration.ZERO;
		
		
		Customers.getInstance().addCustomer(this);
	}

	public Customer(String name, String surname, int creditCardNbr) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.creditCardNbr=creditCardNbr;
		this.coordinates = new Coordinates();
		this.totalAmountOfCashSpent = 0;
		this.totalNumberOfRides=0;
		this.totalTimeSpentOnCar=Duration.ZERO;
		
				Customers.getInstance().addCustomer(this);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setCreditCardNbr(int creditCardNbr) {
		this.creditCardNbr = creditCardNbr;
	}

	public int getCustomerID() {
		return customerID;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public ArrayList<Ride> getPotentialRideOrder() {
		return potentialRideOrder;
	}	
	
	public Duration getTotalTimeSpentOnCar() {
		return totalTimeSpentOnCar;
	}

	public void setTotalTimeSpentOnCar(Duration totalTimeSpentOnCar) {
		this.totalTimeSpentOnCar = totalTimeSpentOnCar;
	}

	public double getTotalAmountOfCashSpent() {
		return totalAmountOfCashSpent;
	}

	public void setTotalAmountOfCashSpent(double totalAmountOfCashSpent) {
		this.totalAmountOfCashSpent = totalAmountOfCashSpent;
	}

	public int getTotalNumberOfRides() {
		return totalNumberOfRides;
	}

	public void setTotalNumberOfRides(int totalNumberOfRides) {
		this.totalNumberOfRides = totalNumberOfRides;
	}

	//ajouter dans le main une liste des string de classes concrètes de rides dispos, créer une instance de chaque ride avec juste les coordonnées de départ et d'arrivée et le même traffic; cela est possible seulement si on calcule le traffic avant d'instancier les différentes rides.
	//en améliorant la factory (abstract factory?) on peut faire en sorte que cette liste grandisse toute seule quand on crée une nouvelle sous classe de Ride
	public void comparePrices(Coordinates destination) {
		Traffic traf = new Traffic();
		Coordinates departure = this.getCoordinates();
		for (String typeOfRide : RideFactory.getTypeOfRides()) {
			Ride ride = RideFactory.createRide(typeOfRide, departure, destination, traf);
			this.potentialRideOrder.add(ride);
			ride.computePrice(ride);
			System.out.println("The price for an "+typeOfRide+" ride is "+ride.getPrice()+"€.");	 
		}	
	}
	
	//le for et if nous permettent de vérifier que c'est bien une des rides pour lesquelles le client a demandé le prix
	public void selectRide(Ride selectedRide) {
		for (Ride potentialRide : this.potentialRideOrder) {
			if (potentialRide.equals(selectedRide)) {
				selectedRide.status="unconfirmed";
				selectedRide.setCustomer(this);
				potentialRideOrder=null;
				selectedRide.proposeRideToDrivers();
				
				//ajout de la ride à la liste des riderequests. A FAIRE ?
			} //the ride is waiting to be confirmed by a driver 
		}
	}
	
	
	public void cancelRide(Ride ride) {
		if (ride.status=="unconfirmed" || ride.status=="confirmed") {
			ride.status="canceled";
			ride.driver.setState("on-duty"); // il est déjà On-Duty, mais pour éviter les pb de thread au cas où il annule au moment de monter dans voiture.}
		else {System.out.println("Sorry, the action is impossible since the ride has already begun.");}
	}


}
