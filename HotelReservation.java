package assignment1;

public class HotelReservation extends Reservation {
	
	// fields
	private Hotel aHotel;
	private String roomType;
	private int numNights;
	private int hotelPrice;
	
	// constructor
	public HotelReservation(String name, Hotel aHotel, String roomType, int numNights) {
		super(name);
		this.aHotel = aHotel;
		this.roomType = roomType;
		this.hotelPrice = aHotel.reserveRoom(roomType);
		this.numNights = numNights;
	}
	// number of nights on reservation
	public int getNumOfNights() {
		return numNights;
	}
	// cost of reservation
	public int getCost() {
		int finalCost = (hotelPrice)*(numNights);
		return finalCost;
	}
	// equals method
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof HotelReservation) {
			HotelReservation aHotelReservation = (HotelReservation) anObject; // to avoid type casting
			if ((aHotelReservation.reservationName().equals(this.reservationName())) && // if names equal
			   (aHotelReservation.roomType.equalsIgnoreCase(this.roomType)) &&  // if room type equal
			   (aHotelReservation.aHotel == this.aHotel) &&  // if hotel equal
			   (aHotelReservation.numNights == this.numNights) &&  // if number nights equal
			   (aHotelReservation.getCost() == aHotelReservation.getCost())) { // if cost equal
					return true;
			}
			return false;
		}
		return false;
	}
}
