package myUberCLItest;

import myUberStatistics.DriverBalance;

public class DisplayDriversCommand {
	public static void main(String[] args){
		try {
			if (args[0] == "mostappreciated"){
				DriverBalance.mostAppreciatedDriver();
			if (args[0] == "mostoccupied"){
				DriverBalance.mostAppreciatedDriver();
			
			}
				
			}
		}
	}

}
