package assignment1;

public class Customer {

	// fields
	private String name;
	private int balance;
	private Basket reservations;
	
	// constructor
	public Customer(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.reservations = new Basket();
	}
	// method to retrieve name
	public String getName() {
		return name;
	}
	// method to retrieve balance
	public int getBalance() {
		return balance;
	}
	// method to get basket
	public Basket getBasket() {
		return reservations;
	}
	// method to add funds to customer
	public int addFunds(int toAdd) {
		if (toAdd < 0) {
			throw new IllegalArgumentException("Cannot add negative amount");
		}
		else {
			this.balance = this.balance + toAdd;
		}
		return this.balance;
	}
	// method to add to basket (by name)
	public int addToBasket(Reservation aReservation) {
		// check if name on reservation is same as customer name
		if (aReservation.reservationName().equalsIgnoreCase(this.name)){
			return reservations.add(aReservation);
		}
		// if not, throw exception
		else {
			throw new IllegalArgumentException("Cannot find reservation with name" + this.name);
		}
	}
	// method to add to basket (hotel and bnb)
	public int addToBasket(Hotel aHotel, String roomType, int numNights, boolean breakfast) {
		// create 2 reservations, one of type hotel and other of type bnb
		Reservation hotelRes = new HotelReservation(this.name, aHotel, roomType, numNights);
		Reservation bnbRes = new BnBReservation(this.name, aHotel, roomType, numNights);
		int toAdd = 0; // initialize
		// if breakfast included, add bnb type reservation
		if (breakfast == true) {
			toAdd = reservations.add(bnbRes);
		}
		// otherwise add hotel type reservation
		else if (breakfast == false) {
			toAdd = reservations.add(hotelRes);
		}
		// return which was added (returns int)
		return toAdd;
	}
	// method to add to basket (airport)
	public int addToBasket(Airport air1, Airport air2) {
		Reservation flightRes = new FlightReservation(this.name, air1, air2);
			return reservations.add(flightRes);
	}
	// method to remove from basket
	public boolean removeFromBasket(Reservation aReservation) {
		return reservations.remove(aReservation);
	}
	// method for check out
	public int checkOut() {
		// throw exception if customer balance less than total cost of basket
		if (this.balance < reservations.getTotalCost()) {
			throw new IllegalStateException();
		}
		else {
			this.balance = this.balance - reservations.getTotalCost(); // charger customer
			reservations.clear();  // clear basket
			return this.balance;  // return final balance
		}
	}
}

