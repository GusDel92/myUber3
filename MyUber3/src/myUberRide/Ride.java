package myUberRide;

import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import myUberCar.Car;
import myUberCar.CarFactory;
import myUberCustomer.Customer;
import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberStatistics.MyUberBookOfRides;
import myUberTools.Coordinates;
import myUberTools.Traffic;

public abstract class Ride implements Request{

	private Coordinates departure;
	private Coordinates destination;
	protected String type;
	private int nbrOfPassengers;
	private double length;
	private Traffic traffic;
	private Duration duration;
	private double price;
	protected ArrayList<Car> potentialCars = new ArrayList<Car>();
	private String status;
	private Car car;
	private Customer customer;
	private Driver driver;
	private int rate;
	
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
		super();
		this.departure = departure;
		this.destination = destination;
		this.traffic = traffic;
		this.length = departure.distanceTo(destination);
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
	
	public ArrayList<Car> getPotentialDrivers() {
		return potentialCars;
	}

	public void setPotentialDrivers(ArrayList<Car> potentialDrivers) {
		this.potentialCars = potentialDrivers;
	}

	public Coordinates getDeparture() {
		return departure;
	}

	public Coordinates getDestination() {
		return destination;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public double getPrice() {
		return price;
	}	
	
	public Car getCar() {
		return car;
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

	
	
	public void recoverPotentialCars(){
		for (Car car : CarFactory.getAllCars()){
			car.accept(this);
		}
	}
	
	public void sortPotentialCars() {
		int n = potentialCars.size();
		for (int i=0;i<=n;i++) {
			for (int j=1;j<=n-2;j++) {
				Car car1 = potentialCars.get(j);
				Car car2 = potentialCars.get(j+1);
				double distanceFromDeparture1 = car1.getCarPosition().distanceTo(departure);
				double distanceFromDeparture2 = car2.getCarPosition().distanceTo(departure);
				if (distanceFromDeparture1>distanceFromDeparture2){
					potentialCars.remove(j);
					potentialCars.add(j+1, car1);
				}
			}
		}
	}
	
	public void proposeRideToDrivers() {
		this.recoverPotentialCars();
		//System.out.print(this.potentialCars.get(0).getCurrentDriver().getDriverID()+this.potentialCars.get(1).getCurrentDriver().getDriverID()+this.potentialCars.get(2).getCurrentDriver().getDriverID());
		this.sortPotentialCars();
		while (this.status=="unconfirmed") {	
			for (Car potentialCar : this.potentialCars) {
				if (potentialCar.getCurrentDriver().getState()=="on-duty") {
					Scanner sc = new Scanner(System.in);
					System.out.println(potentialCar.getCurrentDriver().getName()+" do you want to take an "+this.type+" ride ?"); //from"+this.departure.getLatitude()+", "+this.departure.getLongitude()+" to "+this.destination.getLatitude()+", "+this.destination.getLongitude()+" ?");
					Boolean answer = sc.nextBoolean();
					//sc.close();
					if (answer==true){
						PoolRequests.deleteRequest(this.request);
						this.driver=potentialCar.getCurrentDriver();
						this.status="confirmed";
						this.car=potentialCar;
						this.driver.setState("on-a-ride");
						this.manageRide();
						potentialCars.removeAll(potentialCars);
						break;
					}
					
				}
				
			}
		}
		//System.out.println("There is no available driver for your ride. Please try again.");
		}
			
			
	

	
	public void manageRide() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Client " + this.getCustomer().getName()+" picked up ?");
		//System.out.println("Client "+this.getCustomer().getSurname()+" récupéré ?");
		Boolean answer = sc.nextBoolean();
		if (answer==true) {
			//MyUberBookOfRides.addRideToTheBook(this);
			this.driver.setState("on-a-ride");
			LocalDateTime departureTime = LocalDateTime.now();
			this.setStatus("ongoing");
			System.out.println("Client " + this.getCustomer().getName()+" dropped off ?");
			Boolean answer2 = sc.nextBoolean();
			if (answer2==true) {
				this.setStatus("completed");
				this.driver.setState("on-duty");
				this.setDuration(Duration.between(departureTime, LocalDateTime.now()));
				this.driver.setTotalDrivingCustomersTime(this.driver.getTotalDrivingCustomersTime().plus(this.duration));
				this.customer.setTotalTimeSpentOnCar(this.customer.getTotalTimeSpentOnCar().plus(this.duration));
				this.customer.setTotalAmountOfCashSpent(this.customer.getTotalAmountOfCashSpent() + this.price);
				this.getCustomer().setTotalNumberOfRides(this.customer.getTotalNumberOfRides()+1);
				this.getDriver().setTotalNumberOfRides(this.driver.getTotalNumberOfRides()+1);
				this.rate=this.customer.giveARate(this);
				this.driver.computeNewRate(this);
				}
			}
		//sc.close();
	}

	public double getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
