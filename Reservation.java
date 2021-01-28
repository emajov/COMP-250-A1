package assignment1;

public abstract class Reservation {
	
	// fields
	private String name;
	
	// constructor
	public Reservation(String name) {
		this.name = name;
	}
	// method to retrieve name on reservation
	public final String reservationName() {
		return name;
	}
	// abstract method to get cost
	public abstract int getCost();
	
	// equals method returning boolean
	public abstract boolean equals(Object anObject);
}
