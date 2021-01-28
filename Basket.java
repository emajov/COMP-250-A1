package assignment1;

public class Basket {
	
	// fields
	private Reservation[] resArray;
	
	// constructor
	public Basket() {
		this.resArray = new Reservation[0];
	}
	// to create shallow copy of array
	public Reservation[] getProducts() {
		return resArray.clone();
		
	}
	// method to add reservations
	public int add(Reservation aReservation) {
		// create new array of reservations 1 length greater
		Reservation[] newArray = new Reservation[resArray.length + 1];
		int i;
		// iterate through original array and add elements to new array
		for (i = 0; i < resArray.length; i++) {
			newArray[i] = resArray[i];
			}
		// new reservation at one position past last element in resArray 
			// created in new array
		newArray[resArray.length] = aReservation; 
		resArray = newArray;
		int lenNewArray = newArray.length;
		// returns new number of reservations in array
		return lenNewArray;
	}
	
	// method to remove reservations
	public boolean remove(Reservation aReservation) {
		// create new array of reservations with length 1 less than original
		Reservation [] newArray = new Reservation[resArray.length - 1];
		// set boolean value
		boolean check = false;
		int i;
		// iterate through array
		for (i = 0; i < resArray.length; i++) {
			// check if reservation equals input
			if (resArray[i].equals(aReservation)) {
				check = !(check); // change boolean value
			}
			// if true, shift over
			else if (check == true) {
				newArray[i-1] = resArray[i];
			}
			// else, add same element to new array
			else if (check == false) {
				newArray[i] = resArray[i];
			}
		}
		// if set to true, new array is same as original
		if (check == true) {
			resArray = newArray;
		}
		// return boolean 
		return check;
	}
	
	// method to clear reservation array
	public void clear() {
		resArray = new Reservation[0];
	}
	public int getNumOfReservations() {
		int length = resArray.length;
		return length;
	}
	
	// method to get total cost of basket
	public int getTotalCost() {
		int i;
		int sum = 0; // initialize
		// iterate through array
		for (i = 0; i < resArray.length; i++) {
			// get individual price of each reservation
			int price = resArray[i].getCost();
			// add together
			sum = sum + price;
		}
		// return sum (total cost)
		return sum;
	}
}

