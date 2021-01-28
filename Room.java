package assignment1;

public class Room {
	
	// fields
	private String roomType;
	private int roomPrice;
	private boolean roomAvail;
	
	// constructor initializing fields
	public Room(String inputType) {
		if (inputType == null){
			System.out.println("Error, must indicate room type");
		}
		// if room is of type double, assign double attributes
		else if (inputType.equalsIgnoreCase("double")){
			roomType = inputType;
			roomPrice = 9000;
		}
		// if room is of type queen, assign queen attributes
		else if (inputType.equalsIgnoreCase("queen")) {
			roomType = inputType;
			roomPrice = 11000;
		}
		// if room is of type king, assign king attributes 
		else if (inputType.equalsIgnoreCase("king")) {
			roomType = inputType;
			roomPrice = 15000;
		}
		// otherwise, throw exception
		else {
			throw new IllegalArgumentException("No room of such type");
		}
		// set room availability to true
		roomAvail = true;	
	}
	// constructor for copy
	public Room(Room inputRoom) {
		roomType = inputRoom.roomType;
		roomPrice = inputRoom.roomPrice;
		roomAvail = inputRoom.roomAvail;
	}
	// method to get type of room
	public String getType() {
		return roomType;
	}
	// method to get price of room
	public int getPrice() {
		return roomPrice; 
	}
	// method to change availability (returns opposite of availability)
	public void changeAvailability() {
		roomAvail = (!roomAvail);
	}
	// method to find available rooms
	public static Room findAvailableRoom(Room[] roomArray, String inputRoom) {
		int i; // initialize variable i
		// loop through array
		for (i=0; i<roomArray.length; i++){
			// create rooms at each position of array
			Room room = roomArray[i];
			// check if it is available and type equals input room type
			if ((room.roomAvail) && (room.roomType).equalsIgnoreCase(inputRoom)){
				// if true, return the room at that position and exit loop
				return room;	
			}	
		}
		// otherwise, return null
		return null;
		}
	// method to make room available
	public static boolean makeRoomAvailable(Room[] roomArray, String inputRoom) {
		int i; // initialize
		// do similar to findAvailableRoom method
		for (i=0; i<roomArray.length; i++) {
			Room room = roomArray[i];
			// check if room is not available
			if (!room.roomAvail) {
				// use changeAvailability method to change it
				room.changeAvailability();
				return true;
			}
		}
		// otherwise, return false
		return false;
	}
}
