package myUberDriver;

import java.util.Comparator;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;

import myUberCar.Car;
import myUberCustomer.Customer;
import myUberRide.Ride;
import myUberStatistics.DriverBalance;

public class Driver {
	
	private static int driverCounter = 0;
	private int driverID;
	private String name;
	private String surname;
	private String state;
	private Car actualCar;
	private double rate;
	private int totalNumberOfRides;
	private Duration totalInCarTime;
	private Duration totalOnDutyTime;
	private Duration totalDrivingCustomersTime;
	private Duration totalOffDutyTime;
	private double totalAmountCashed;
	private LocalDateTime lastConnexionTime;
	private LocalDateTime lastOffDutyTime;
	
	public Driver(String name, String surname) {
		driverCounter++;
		this.driverID=driverCounter;
		this.state="offline";
		this.name=name;
		this.surname=surname;
		this.rate=0;
		this.totalNumberOfRides=0;
		this.totalAmountCashed=0;
		this.totalInCarTime=Duration.ZERO;
		this.totalOffDutyTime=Duration.ZERO;
		this.totalOnDutyTime=Duration.ZERO;
		this.totalDrivingCustomersTime=Duration.ZERO;
		
		Drivers.getInstance().addDriver(this);
	}

	
	public double getTotalAmountCashed() {
		return totalAmountCashed;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public void setTotalAmountCashed(double totalAmountCashed) {
		this.totalAmountCashed = totalAmountCashed;
	}


	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (Drivers.possibleStates.contains(state)) {
			if (this.state.equals(state)) {System.out.println("Error: You are already "+ this.state);}
			else {this.state = state;}
		}
		else {System.out.println("The state "+state+" does not exist.");}
	}
	
	public Car getActualCar() {
		return actualCar;
	}

	public void setActualCar(Car actualCar) {
		this.actualCar = actualCar;
	}

	public int getTotalNumberOfRides() {
		return totalNumberOfRides;
	}


	public void setTotalNumberOfRides(int totalNumberOfRides) {
		this.totalNumberOfRides = totalNumberOfRides;
	}


	public Duration getTotalInCarTime() {
		return totalInCarTime;
	}


	public void setTotalInCarTime(Duration totalInCarTime) {
		this.totalInCarTime = totalInCarTime;
	}


	public Duration getTotalOnDutyTime() {
		return totalOnDutyTime;
	}


	public void setTotalOnDutyTime(Duration totalOnDutyTime) {
		this.totalOnDutyTime = totalOnDutyTime;
	}


	public Duration getTotalDrivingCustomersTime() {
		return totalDrivingCustomersTime;
	}


	public void setTotalDrivingCustomersTime(Duration totalDrivingCustomersTime) {
		this.totalDrivingCustomersTime = totalDrivingCustomersTime;
	}


	public Duration getTotalOffDutyTime() {
		return totalOffDutyTime;
	}


	public void setTotalOffDutyTime(Duration totalOffDutyTime) {
		this.totalOffDutyTime = totalOffDutyTime;
	}


	public LocalDateTime getLastConnexionTime() {
		return lastConnexionTime;
	}


	public void setLastConnexionTime(LocalDateTime lastConnexion) {
		this.lastConnexionTime = lastConnexion;
	}


	
	public LocalDateTime getLastOffDutyTime() {
		return lastOffDutyTime;
	}


	public void setLastOffDutyTime(LocalDateTime lastOffDutyTime) {
		this.lastOffDutyTime = lastOffDutyTime;
	}


	public int getDriverID() {
		return driverID;
	}


	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}


	public void acceptRide(Ride ride) {
		ride.setDriver(this);
		this.state="on-a-ride";
		ride.setStatus("confirmed");
		
	}
	
	public void computeNewRate(Ride ride) {
		this.rate=(this.rate+ride.getRate())/(this.totalNumberOfRides);
	}

	public void connect(Car car, String desiredTypeOfRide) {
		if (car.getOwnersList().contains(this)){
			if (car.getCurrentDriver()==null) {
				if (car.getPossibleTypesOfRide().contains(desiredTypeOfRide)) {
				car.setCurrentDriver(this);
				car.setActualTypeOfRideDesiredByDriver(desiredTypeOfRide);
				this.setActualCar(car);
				this.setState("on-duty");
				this.setLastConnexionTime(LocalDateTime.now());
				Drivers.addOnDutyDriver(this);
				}
				else {System.out.println("Imposible d'effectuer ce type de ride avec votre voiture.");}
			}
			else {System.out.println("Cette voiture est déjà occupée.");}
		}
		else {System.out.println("Vous n'êtes pas propriétaire de cette voiture.");}
	}

	public void disconnect() {
		if (this.getState()!="on-a-ride"){
			
			this.getActualCar().setActualTypeOfRideDesiredByDriver(null);
			this.getActualCar().setCurrentDriver(null);
			this.setActualCar(null);
			this.setState("offline"); 
			this.setTotalInCarTime(this.getTotalInCarTime().plus(Duration.between(this.lastConnexionTime, LocalDateTime.now())));
			this.setTotalOnDutyTime(this.getTotalInCarTime().minus(this.getTotalDrivingCustomersTime().plus(this.getTotalOffDutyTime())));}
		else {
			System.out.println("Veuillez finir la course en cours avant de vous déconnecter.");
		}
	}
	
	
	public void takeABreak() {
		if (this.getState()!="on-a-ride"){
			this.setState("off-duty");
			this.setLastOffDutyTime(LocalDateTime.now());}
		else {System.out.println("Veuillez finir la course en cours avant de commencer votre pause.");
		}
	}
	public void endOfTheBreak() {
		if (this.getState()=="off-duty") {
			this.setState("on-duty");
			this.setTotalOffDutyTime(getTotalOffDutyTime().plus(Duration.between(this.lastConnexionTime, LocalDateTime.now())));
			}
		else {System.out.println("Impossible d'effectuer l'action, vous n'étiez pas en pause.");
		}
	}
	
	/**
	 * A comparator used in the driver balance sorting methods.
	 */
	public static Comparator<Driver> OccupationComparator = new Comparator<Driver>() {

        @Override
        public int compare(Driver e1, Driver e2) {
            double x = DriverBalance.occupationRate(e2) - DriverBalance.occupationRate(e1);
            if (x<0){return (int)-1;}
            else if (x==0){return (int)0;}
            else {return (int)1;}
		    };
	};
	
	/**
	 * A comparator used in the driver balance sorting methods.
	 */
	
	public static Comparator<Driver> AppreciationComparator = new Comparator<Driver>() {

        @Override
        public int compare(Driver e1, Driver e2) {
            double x = e2.getRate() - e1.getRate();
            if (x<0){return (int)-1;}
            else if (x==0){return (int)0;}
            else {return (int)1;}
		    };
            };
            

        
}
