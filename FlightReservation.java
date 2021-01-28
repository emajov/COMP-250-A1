package assignment1;

public class FlightReservation extends Reservation {
	
	// fields
	private Airport departure;
	private Airport arrival;
	
	// constructor
	public FlightReservation(String name, Airport departure, Airport arrival) {
		super(name);
		this.departure = departure;
		this.arrival = arrival;
		if (departure.equals(arrival)) {
			throw new IllegalArgumentException("Airports are the same");
		}
	}
	// cost of flight reservation
	public int getCost() {
		int distance = Airport.getDistance(departure, arrival); // distance
		double gallons = (distance/167.52); // total gallons used
		int fees = departure.getFees() + arrival.getFees(); // non static reference
		double price = (124*gallons); // gets price of flight
		double total = (price + fees + 5375); // total price in cents
		int totalPrice = (int)Math.ceil(total); // rounding up to int
		return totalPrice; // return type int
	}
	// equals method
	public boolean equals(Object anObject) {
		if ((anObject instanceof FlightReservation) && // check if type is equal
			(((FlightReservation) anObject).reservationName().equals(this.reservationName())) && // is name equal
			((FlightReservation) anObject).departure.equals(this.departure) && // if departure airport is equal
			((FlightReservation) anObject).arrival.equals(this.arrival)) { // if arrival airport is equal
				return true;
		}
		return false;	
	}
}
