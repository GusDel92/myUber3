package myUberCustomer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import myUberCar.Car;
import myUberRide.Ride;
import myUberRide.RideFactory;
import myUberTools.Coordinates;
import myUberTools.Message;
import myUberTools.Traffic;

/**
 * This class describes a MyUber Customer.
 * @author Cuignet & Thi�baud
 *
 */
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
	
	/**
	 * This methods permit a customer to rate a driver. It is used at the end of the managing ride process.
	 * @param ride
	 * @return void
	 * @author Cuignet & Thi�baud
	 */
	public int giveARate(Ride ride) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please give a rate to your driver (int from 1 to 5)");
		int rate = sc.nextInt();
		return rate;
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

	
	/**
	 * This method allows a customer to compare prices of different type of rides for a given trajectory.
	 * @param destination
	 * @author Cuignet & Thi�baud
	 */
	public void comparePrices(Coordinates destination) {
		Traffic traf = new Traffic();
		Coordinates departure = this.getCoordinates();
		for (String typeOfRide : RideFactory.getTypeOfRides()) {
			Ride ride = RideFactory.createRide(typeOfRide, departure, destination, traf);
			this.potentialRideOrder.add(ride);
			ride.computePrice();
			System.out.println("The price for an "+typeOfRide+" ride is "+ride.getPrice()+"�.");	 
		}	
	}
	
	
	/**
	 * This method permits to a customer to select the ride he wishes to accomplish. It then erase the other kind of ride which were instantiated during the computing costs process. At the end of this method, the ride is waiting to be confirm by a driver... 
	 * @param selectedRide
	 * @author Cuignet & Thi�baud
	 */
	public void selectRide(Ride selectedRide) {
		for (Ride potentialRide : this.potentialRideOrder) {
			if (potentialRide.equals(selectedRide)) {
				selectedRide.setStatus("unconfirmed");
				selectedRide.setCustomer(this);
				//potentialRideOrder=null;
				selectedRide.proposeRideToDrivers();
			} 
		}
	}
	
	
	
	/**
	 * Allows a customer to cancel his ride under the condition that it has not been confirmed yet by a driver. 
	 * @author Cuignet & Thi�baud
	 * @param ride
	 */
	public void cancelRide(Ride ride) {
		if (ride.getStatus()=="unconfirmed" || ride.getStatus()=="confirmed") {
			ride.setStatus("canceled");
			} 
		else {System.out.println("Sorry, the action is impossible since the ride has already begun.");}
	}


	/**
	 * This method is a comparator we use in customer statistic computing, to sort the customers.
	 */
	public static Comparator<Customer> TotalNumberOfRidesComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer e1, Customer e2) {
            return e2.getTotalNumberOfRides() - e1.getTotalNumberOfRides();
        }
    };
    
    public static Comparator<Customer> TotalAmountOfCashComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer e1, Customer e2) {
            double x = e2.getTotalAmountOfCashSpent() - e1.getTotalAmountOfCashSpent();
            if (x<0){return (int)-1;}
            else if (x==0){return (int)0;}
            else {return (int)1;}
		    };
            };      
          
            
            
        
}
