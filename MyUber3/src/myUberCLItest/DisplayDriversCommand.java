package myUberCLItest;

import myUberStatistics.DriverBalance;

public class DisplayDriversCommand {
	public static void main(String[] args){
		
			try {
				Boolean done = false;
				synchronized(done){
				if (args[0] == "mostappreciated"){
					DriverBalance.mostAppreciatedDriver();
					done = true;}
				if (args[0] == "mostoccupied"){
					DriverBalance.leastOccupiedDriver();
					done = true;}
				}
				if (done==false){System.out.println("Wrong entry : try 'mostappreciated' or 'mostoccupied'");}
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to display driver command.");
			}
			
	}

}
