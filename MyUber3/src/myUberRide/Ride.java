package myUberRide;

import myUberTools.Coordinates;

public abstract class Ride {

	private Coordinates departure;
	private Coordinates destination;
	private double length;
	private String traffic;
	private double duration;
	private double price;
	private String status;
	//private Date startDate;
	//private Date endDate;
	public int driverId;
	public double rate;
	
	private double rateLengthInf5km;
	private double rateLength5To10km;
	private double rateLength10To20km;
	private double rateLengthSup20km;
	private double rateLowTraffic;
	private double rateMediumTraffic;
	private double rateHeavyTraffic;
	
	public Ride(Coordinates departure, Coordinates destination) {
		//donner l'h
		
		//en déduire le traffic
		//this.traffic=getTraffic(startDate);
		//calculer la longueur
		computeLength(this);
		//en déduire la durée
		computeDuration(this);
	}

	private void computeLength(Ride ride) {
		this.length=Math.sqrt(Math.pow(this.departure.latitude-this.destination.latitude, 2)+Math.pow(this.departure.longitude-this.destination.longitude,2));
		
	}


	

	//this function returns the duration of the ride in minutes (length must be given in km)
	//on peut rajouter un catch error pour le cas où le traffic ou la longueur de la course n'est pas encore entré
	public void computeDuration(Ride ride) {
		if (this.traffic=="low-traffic") {this.duration=this.length/15*60;}
		else if (this.traffic=="medium-traffic") {this.duration=this.length/7.5*60;}
		else if (this.traffic=="heavy-traffic") {this.duration=this.length/3*60;}
	}
	
}
