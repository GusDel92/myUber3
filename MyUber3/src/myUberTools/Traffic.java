package myUberTools;

/**
 * Traffic class determines the traffic at a given time. It is based on a probabilistic approach.
 * @author Cuignet & Thiébaud
 *
 */
public class Traffic {

	private int hour;
	private static double aleatNbr;
	public String actualTraffic;
	public double averageSpeed;
	
	
	/**
	 * This method determines the traffic according to the hour of the day. The traffic is supposed to be constant during a ride.
	 * @return
	 * @author Cuignet & Thiébaud
	 */
	public String getTraffic(int hour) {

		aleatNbr=Math.random();
		if (hour>=22 | hour<=7) {
			if (aleatNbr<=0.95) {return "low-traffic";}
			else if (aleatNbr<=0.99) {return "medium-traffic";}
			else {return "heavy-traffic";}
		}
		else if (hour>=7 & hour<=11) {
			if (aleatNbr<=0.05) {return "low-traffic";}
			else if (aleatNbr<=0.25) {return "medium-traffic";}
			else {return "heavy-traffic";}
		}
		else if (hour>=11 & hour<=17) {
			if (aleatNbr<=0.15) {return "low-traffic";}
			else if (aleatNbr<=0.85) {return "medium-traffic";}
			else {return "heavy-traffic";}
		}
		else if (hour>=17 & hour<=22) {
			if (aleatNbr<=0.01) {return "low-traffic";}
			else if (aleatNbr<=0.05) {return "medium-traffic";}
			else {return "heavy-traffic";}
		}
		return null;
	}

	public String getActualTraffic() {
		return actualTraffic;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public Traffic() {
		this.actualTraffic = getTraffic(Date.getHour());
		if(this.actualTraffic.equals("low-traffic")) {this.averageSpeed=15;}
		else if(this.actualTraffic.equals("medium-traffic")) {this.averageSpeed=7.5;}
		else if(this.actualTraffic.equals("heavy-traffic")) {this.averageSpeed=3;}
	}
	public Traffic(int hour) {
		this.actualTraffic = getTraffic(hour);
	}
}
