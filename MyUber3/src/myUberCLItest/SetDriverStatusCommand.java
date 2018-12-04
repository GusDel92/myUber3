package myUberCLItest;

import myUberDriver.Driver;
import myUberDriver.Drivers;

public class SetDriverStatusCommand {

	public static void main(String[] args) {
		//args[0] is the driverID; args[1] is the new status
		
		try {
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
		} 
		catch (NumberFormatException e) {
			System.out.println("ERROR: Wrong format of the driverID. Please enter integers.");
		}
		
		finally {MenuCommand.main(args);}
	}

}
