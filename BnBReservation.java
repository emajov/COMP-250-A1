package assignment1;

public class BnBReservation extends HotelReservation {
	
	// constructor
	public BnBReservation(String name, Hotel aHotel, String roomType, int numNights) {
		super(name, aHotel, roomType, numNights);
	}
	// method to get cost
	public int getCost() {
		int finalPrice = super.getCost() + (super.getNumOfNights())*1000; // 10 extra dollars per night
		return finalPrice;
	}
}
