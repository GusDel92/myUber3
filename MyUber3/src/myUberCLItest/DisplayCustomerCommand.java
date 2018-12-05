package myUberCLItest;

import myUberStatistics.CustomerBalance;


public class DisplayCustomerCommand {
	
	public static void main(String[] args){
		
		try {
			Boolean done = false;
			synchronized(done){
			if (args[0] == "mostfrequent"){
				CustomerBalance.mostChargedCustomer();
				done = true;}
			if (args[0] == "mostcharged"){
				CustomerBalance.mostFrequentCustomer();
				done = true;}}
			if (done==false){System.out.println("Wrong entry : try 'mostfrequent' or 'mostcharged'");}
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to display driver command.");
		}
		
}

}
