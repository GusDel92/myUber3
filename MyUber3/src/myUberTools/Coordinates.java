package myUberTools;

import java.util.Scanner;

public class Coordinates {

	public double longitude;
	public double latitude;
	
	protected double getLongitude() {
		return longitude;
	}
	protected void setLongitude(double x) {
		this.longitude = x;
	}
	protected double getLatitude() {
		return latitude;
	}
	protected void setLatitude(double y) {
		this.latitude = y;
	}
	
	public Coordinates destinationChoice() {
		Coordinates dest = new Coordinates();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lattitude of the destination: ");
		dest.setLatitude(scan.nextInt());
		System.out.println("Enter the lattitude of the destination: ");
		dest.setLongitude(scan.nextInt());
		scan.close();
		return dest;
	}
	
}