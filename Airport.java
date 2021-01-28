package assignment1;

public class Airport {
	
	// fields
	private int x;
	private int y;
	private int fee;
	
	// constructor
	public Airport(int x, int y, int fee) {
		this.x = x;
		this.y = y;
		this.fee = fee;
	}
	// method that gets airport fees
	public int getFees() {
		return fee;
	}
	// method for distance between airports (must return type int)
	public static int getDistance(Airport air1, Airport air2) {
		// distance will originally be a double
		// uses mathematical equation for distance
		double dis = Math.sqrt((Math.pow(air2.x-air1.x, 2)) + (Math.pow(air2.y-air1.y, 2)));
		// must return ceiling value of double
		int distance = (int)Math.ceil(dis);
				return distance;
	}
}

