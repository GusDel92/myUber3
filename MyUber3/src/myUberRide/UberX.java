package myUberRide;

import myUberCar.BerlineCar;
import myUberCar.StandardCar;
import myUberCar.VanCar;
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

	@Override
	public void visit(StandardCar standardCar) {
		if(standardCar.getCurrentDriver()!=null & standardCar.getActualTypeOfRideDesiredByDriver()!=null) {
			if (standardCar.getCurrentDriver().getState().equalsIgnoreCase("on-duty") & standardCar.getActualTypeOfRideDesiredByDriver().equals("uberX")){
				this.potentialCars.add(standardCar);}
		}
	}

	
	@Override
	public void visit(BerlineCar berlineCar) {
		if(berlineCar.getCurrentDriver()!=null & berlineCar.getActualTypeOfRideDesiredByDriver()!=null) {
			if (berlineCar.getCurrentDriver().getState() == "on-duty" & berlineCar.getActualTypeOfRideDesiredByDriver() == "uberVan"){
				this.potentialCars.add(berlineCar);}
		}
	}

	@Override
	public void visit(VanCar vanCar) {
		if(vanCar.getCurrentDriver()!=null & vanCar.getActualTypeOfRideDesiredByDriver()!=null) {
			if (vanCar.getCurrentDriver().getState() == "on-duty" & vanCar.getActualTypeOfRideDesiredByDriver() == "uberStandard"){
				this.potentialCars.add(vanCar);}
		}
	}

}
