package myUberCustomer;

import java.util.ArrayList;
import java.util.Scanner;

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
    private ArrayList<Message> messageBox = new ArrayList<Message>();
    private ArrayList<Ride> rideOrder = new ArrayList<Ride>();
	
	
	public Customer(String name, String surname) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.coordinates.longitude=0;
		this.coordinates.latitude=0;
		
		
		Customers.getInstance().addCustomer(this);
	}

	public Customer(String name, String surname, int creditCardNbr) {
		counter++;
		this.customerID=counter;
		this.name=name;
		this.surname=surname;
		this.creditCardNbr=creditCardNbr;
		this.coordinates.longitude=0;
		this.coordinates.latitude=0;
		
		
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
	
	//ajouter dans le main une liste des string de classes concrètes de rides dispos, créer une instance de chaque ride avec juste les coordonnées de départ et d'arrivée et le même traffic; cela est possible seulement si on calcule le traffic avant d'instancier les différentes rides.
	//en améliorant la factory (abstract factory?) on peut faire en sorte que cette liste grandisse toute seule quand on crée une nouvelle sous classe de Ride
	public void comparePrices(Coordinates departure, Coordinates destination) {
		Traffic traf = new Traffic();
		for (String typeOfRide : RideFactory.getTypeOfRides()) {
			Ride ride = RideFactory.createRide(typeOfRide, departure, destination, traf);
			this.rideOrder.add(ride);
			ride.computePrice(ride);
			System.out.println("The price for an"+typeOfRide+"ride is"+ride.getPrice()+"€.");	 
		}	
	}
	
	//le for et if nous permettent de vérifier que c'est bien une des rides pour lesquelles le client a demandé le prix
	public void selectRide(Ride selectedRide) {
		for (Ride possibleRide : this.rideOrder) {
			if (possibleRide.equals(selectedRide)) {
				selectedRide.status="unconfirmed";
				
			} //the ride is waiting to be confirmed by a driver
		}
	}
	
	public void cancelRide(Ride ride) {
		ride.status="canceled";
		ride.driver.setState("on-duty");
	}

}