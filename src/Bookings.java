import java.util.ArrayList;

/**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */
public class Bookings {
	
	private int bookingID; 								//stores the Booking id read from the bookings file.
	private int customerID;								//stores the Customer id read from the bookings file.
	private ArrayList<Integer> serviceCodes;			//stores the each service code read from bookings the file.
	private float totalPrice;							//stores the total price read from the bookings file.
	private String date;								//stores the dates read from the bookings file.
	private int servCodes;								//stores singular service codes. 
	private ArrayList<Integer> joinArray;				//stores the primary keys from the bookings file	
	private int bIndex;									//will store the index of a particular arrayList element
	private float tenPercent;							//stores the calculation of 10% of the total service price
	boolean trueOrFalse;								//used to sure whether a a particular input is true or false 
	private float discount;								//used to store the accepted modified price
	private String bFile;								//stores the name of the file that was read	
	private int largest;								//stores the largest number obtained during the file processing 
	private int newIndex;								//used to store the new index of a booking

	
	public Bookings() {}
	
	/**
	 * This constructor was used to store the information read from the Bookings file for an arrayList. 
	 * 
	 * @param bookingID passes the booking id read from the file 
	 * @param customerID passes the customer id read from the file 
	 * @param date passes the date read from the file 
	 * @param totalPrice passes the total price read from the file 
	 * @param serviceCodes passes the serviceCodes arrayList read from the file 
	 */
	public Bookings(int bookingID, int customerID, String date, float totalPrice, ArrayList<Integer> serviceCodes, ArrayList<Integer> joinArray, int largest) {
		
		
		this.bookingID = bookingID;
		this.customerID = customerID;
		this.date = date;
		this.totalPrice = totalPrice;
		this.serviceCodes = serviceCodes;
		this.joinArray = joinArray;	
		this.largest = largest;
	}
	
	/**
	 * @return the newIndex returns the new index obtained from a method in the main program
	 */
	public int getNewIndex() {
		return newIndex;
	}

	/**
	 * @param newIndex the newIndex to set the new index obtained from the main program
	 */
	public void setNewIndex(int newIndex) {
		this.newIndex = newIndex;
	}
	
	/**
	 * @param bookingID the bookingID to set the booking obtained from the main program
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	/**
	 * @param customerID the customerID to set the customer id set from the main program 
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @param serviceCodes the serviceCodes to set the codes from the main program
	 */
	public void setServiceCodes(ArrayList<Integer> serviceCodes) {
		this.serviceCodes = serviceCodes;
	}

	/**
	 * @return the largest returns the largest number obtained from the file processing
	 */
	public int getLargest() {
		return this.largest;
	}

	/**
	 * @return the bFile returns the bookings file name
	 */
	public String getbFile() {
		return this.bFile;
	}

	/**
	 * @param bFile the bFile to set the bookings file name
	 */
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	/**
	 * @return the discount returns the discount if the modified amount is accepted
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set the discount amount
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the trueOrFalse returns the value true or false base on the interactions from the user
	 */
	public boolean isTrueOrFalse() {
		return this.trueOrFalse;
	}

	/**
	 * @param trueOrFalse the trueOrFalse to set set a true or false boolean based on interaction or methods in the main program
	 */
	public void setTrueOrFalse(boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}

	/**
	 * @return the tenPercent returns the 10 of the total price of the service codes
	 */
	public float getTenPercent() {
		return this.tenPercent = this.totalPrice - (this.totalPrice * 10/100);
	}
	
	
	/**
	 * @param totalPrice the totalPrice to set the total price from the main program
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @param date the date to set the date inputed from the main program
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the bIndex returns arrayList index from the main program
	 */
	public int getbIndex() {
		return bIndex;
	}

	/**
	 * @param bIndex the bIndex to set the arrayList index obtained from the main program 
	 */
	public void setbIndex(int bIndex) {
		this.bIndex = bIndex;
	}

	/**
	 * @return the joinArray returns the contents of the arrayList
	 */
	public ArrayList<Integer> getJoinArray() {
		return joinArray;
	}

	/**
	 * @return the bookingID returns bookings id obtained from the main program
	 */
	public int getBookingID() {
		return this.bookingID;
	}

	/**
	 * @return the customerID returns customer id obtained from the main program
	 */
	public int getCustomerID() {
		return this.customerID;
	}

	/**
	 * @return the serviceCodes returns the content of the arrayList obtained during the file processing 
	 */
	public ArrayList<Integer> getServiceCodes() {
		return this.serviceCodes;
	}

	/**
	 * @return the totalPrice returns the total price obtained from the main program
	 */
	public float getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @return the date returns the date obtained from the main program
	 */ 
	public String getDate() {
		return this.date;
	}

	/**
	 * @return the servCodes returns a singular service code obtained from the main program
	 */
	public int getServCodes() {
		return this.servCodes;
	}
	
	/**
	 * @param largest the largest to set the largest number passed from the main program
	 */
	public void setLargest(int largest) {
		this.largest = largest;
	}

	/**
	 * the way the code was formatted was inspired from https://stackoverflow.com/questions/40903364/how-to-display-elements-of-arraylist-without-the-braces.
	 * 
	 * this code is used to display the bookings file details.
	 */
	public String toString() {
		
		String str = String.format("%s%11d\t\s\s%11d\t\t$%-8.2f\t\s\s", this.date, this.bookingID, this.customerID, this.totalPrice) 
				+ this.serviceCodes.toString().replace("[","").replace("]","");
		//end of code.
		
		return str;
		
	}
	//this code is used for the display detail option and displays specific information for the function. 
	public String toString1() {
		
		String str ="Date: " + this.date + "\n" + "Booking Id: " + this.bookingID + "\n" + "Customer Id: " +  this.customerID;
		
		return str;
		
	}
	
	//this code is used to display the information to display the information in a specific format.
	public String toString3() {
		
		String str = this.bookingID + "," + this.customerID + "," + this.date + "," +  this.totalPrice + "," 
					+ this.serviceCodes.toString().replace("[","").replace("]","").replace(" ", "");
		
		return str;
		
	}

}
