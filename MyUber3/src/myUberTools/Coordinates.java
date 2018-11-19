package myUberTools;

import java.util.Scanner;


/**
 * Coordinates is a tool that permits to manage GPS positions of different objects : car, driver and customer
 * @ author Cuignet & Thiébaud
 *
 */
public class Coordinates {

	private double longitude;
	private double latitude;
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double x) {
		this.longitude = x;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double y) {
		this.latitude = y;
	}
	
	public Coordinates() {
		this.latitude=0;
		this.longitude=0;
	}
	/**
	 * A tool that permit the customer to enter the GPS localization of the wished destination.
	 * @author Cuignet & Thiébaud
	 */
	public static Coordinates destinationChoice() {
		Coordinates dest = new Coordinates();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lattitude of the destination: (relative integer)");
		dest.setLatitude(scan.nextInt());
		System.out.println("Enter the longitude of the destination: (relative integer)");
		dest.setLongitude(scan.nextInt());
		//scan.close();
		return dest;
	}
	/**
	 * 
	 * This method gives the distance (in meters) from a position(given with its GPS coordinates) to the position of the object from which this method is being executed
	 * @param position
	 * @return
	 * @author Cuignet & Thiébaud
	 */
	public double distanceTo(Coordinates position) {
		
		return Math.sqrt(Math.pow((this.getLatitude()-position.getLatitude()),2)+Math.pow((this.getLongitude()-position.getLongitude()),2 ));/*int R = 6378000; //Rayon de la terre en metre
		 
		double lat_a = Math.toRadians(this.latitude);
		double lon_a = Math.toRadians(this.longitude);
		double lat_b = Math.toRadians(position.getLatitude());
		double lon_b = Math.toRadians(position.getLongitude());
				     
		double d = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));
		return d;}*/}
		
		
	
}