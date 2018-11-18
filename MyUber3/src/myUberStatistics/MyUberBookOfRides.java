package myUberStatistics;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import myUberDriver.Driver;
import myUberDriver.Drivers;
import myUberRide.Ride;

public class MyUberBookOfRides {
        
	private static File myUberBookOfRides = new File("myUberBookOfRides");
	
	private static MyUberBookOfRides instance = new MyUberBookOfRides();
	
	public static MyUberBookOfRides getInstance(){
			
			return instance;
			}
	
	
	
	public void addRideToTheBook(Ride ride){
		final FileWriter writer = new FileWriter("myUberBookOfRides");
		writer.write("ceci est un texte\n");
		writer.write("encore et encore");
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }
    }
}