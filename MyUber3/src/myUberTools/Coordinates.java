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
		return d;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	
	
	
}