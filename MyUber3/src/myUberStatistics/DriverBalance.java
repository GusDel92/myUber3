package myUberStatistics;

import myUberDriver.Drivers;

public class DriverBalance {
	
	public int totalRidesPerformedOverAGivenTimeInterval(Driver driver, Time initialTime, Time finalTime){};
	
	public double totalAmoutCashedOverAGivenTimeInterval(Driver driver, Time initialTime, Time finalTime){};
	
	public double onDutyRateOfDriving(Driver driver){};
	
	public double rateOfActivity(Driver driver){};
	/*• least occupied driver: drivers are sorted w.r.t. their occupation rate (ration between
the on-duty time over the total ride time). This allows to potentially setting
up ride allocation policies that increase the use of less occupied drivers (for example
by allocating booking request to the least occupied drivers first).
• most appreciated driver: */
	public Drivers leastOccupiedDriver(Drivers drivers){};
	
	public Drivers mostAppreciatedDriver(Drivers drivers){};
}
