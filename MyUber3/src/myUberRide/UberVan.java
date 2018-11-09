package myUberRide;

import myUberTools.Coordinates;

public class UberVan extends Ride {

	public UberVan(Coordinates departure, Coordinates destination, String traffic) {
		super(departure, destination, traffic);
		// TODO Auto-generated constructor stub
		this.type="ubervan";
		this.rateLengthInf5km=6.2;
		this.rateLength5To10km=7.7;
		this.rateLength10To20km=3.25;
		this.rateLengthSup20km=2.6;
		this.rateLowTraffic=1;
		this.rateMediumTraffic=1.5;
		this.rateHeavyTraffic=1.8;
	}
}
