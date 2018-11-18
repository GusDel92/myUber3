package myUberTools;

import java.util.Scanner;


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
	public static Coordinates destinationChoice() {
		Coordinates dest = new Coordinates();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lattitude of the destination: ");
		dest.setLatitude(scan.nextInt());
		System.out.println("Enter the longitude of the destination: ");
		dest.setLongitude(scan.nextInt());
		//scan.close();
		return dest;
	}
	/**
	 * 
	 * This method gives the distance (in meters) from a position(given with its GPS coordinates) to the position of the object from which this method is being executed
	 * @param position
	 * @return
	 */
	public double distanceTo(Coordinates position) {
		
		int R = 6378000; //Rayon de la terre en metre
		 
		double lat_a = Math.toRadians(this.latitude);
		double lon_a = Math.toRadians(this.longitude);
		double lat_b = Math.toRadians(position.getLatitude());
		double lon_b = Math.toRadians(position.getLongitude());
				     
		double d = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));
		return d;}
		
		
	
}