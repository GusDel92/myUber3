package myUberRide;

import myUberTools.Coordinates;
import myUberTools.Traffic;

public class UberX extends Ride {

	public UberX(Coordinates departure, Coordinates destination, Traffic traffic) {
		super(departure, destination, traffic);
		// TODO Auto-generated constructor stub
		this.type="uberx";
		this.rateLengthInf5km=3.3;
		this.rateLength5To10km=4.2;
		this.rateLength10To20km=1.91;
		this.rateLengthSup20km=1.5;
		this.rateLowTraffic=1;
		this.rateMediumTraffic=1.1;
		this.rateHeavyTraffic=1.5;
	}

}
