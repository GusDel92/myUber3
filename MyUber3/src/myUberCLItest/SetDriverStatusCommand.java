package myUberCLItest;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class SetDriverStatusCommand {

	public static void main(String[] args) {
		//args[0]=driverID; args[1]=new status
		
		boolean done=false;
		for (Driver driver : Drivers.getInstance().getDriversList()) {
			synchronized(driver){
				if (driver.getDriverID()==Integer.parseInt(args[0])) {
				driver.setState(args[1]);
				done=true;
				}
			}
		}
		if (done==false){
			System.out.print("Error: there is no driver with such ID.");
		}
		MenuCommand.main(args);
	}

}
