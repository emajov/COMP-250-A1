package assignment1;

public class Hotel {
	
	// fields
	private String hotelName;
	private Room[] roomArray;
	
	// constructor
	public Hotel(String hotelName, Room[] inputArray) {
		this.hotelName = hotelName;
		// create new array of same size as input array
		Room[] newArray = new Room[inputArray.length];
		int i;
		// loop to create deep copy of array
		for (i=0; i<newArray.length; i++) {
			Room newInput = new Room(inputArray[i]);
			// each element of input array is put into new array
			newArray[i] = newInput;
		}
		// initialize field with new array (copy)
		roomArray = newArray;
	}
	// method used to reserve rooms
	public int reserveRoom(String reserveType) {
			Room isAvailable = Room.findAvailableRoom(this.roomArray, reserveType);
			if (isAvailable != null) {
				isAvailable.changeAvailability();
				return isAvailable.getPrice();
			}
			else {
				throw new IllegalArgumentException("Cannot reserve room of this type");
			}
	}
	// method used to cancel rooms
	public boolean cancelRoom(String cancelType) {
		// use makeRoomAvailable method on specified room array and cancel type
		return Room.makeRoomAvailable(this.roomArray, cancelType);
	}
}
