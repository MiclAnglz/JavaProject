import java.util.ArrayList;

/**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */
public class Customer  {
	
	private int customerID;											//stores the customer Id from the Customers.txt
	private String customerSurname;									//stores the customer Surname name from the Customers.txt
	private String customerFirstName;								//stores the customer First name from the Customers.txt
	private String customerAddress;									//stores the customer Address the Customers.txt
	private String customerSuburb;									//stores the customer Suburb the Customers.txt
	private String customerPostCode;								//stores the customer Postcode the Customers.txt
	private String customerPhoneNumber;								//stores the customer Phone number the Customers.txt
	private ArrayList<Integer> joinArray;							//stores the customer Id in an arrayList from the Customers.txt
	private int cIndex;												//Stores th index of the arrayList
	
	// default constructor.
	public Customer() {}
	/**
	 * This constructor was used to store the information read from the Cusomters.txt for an arrayList. 
	 * 
	 * @param customerID passes the customer ID that was read for Customers.TXT
	 * @param customerSurname passes the customer Surname that was read for Customers.TXT
	 * @param customerFirstName passes the customer First name that was read for Customers.TXT
	 * @param customerAddress passes the customer Address that was read for Customers.TXT
	 * @param customerSuburb passes the customer Suburb that was read for Customers.TXT
	 * @param customerPostCode  passes the customer Post code that was read for Customers.TXT
	 * @param customerPhoneNumber  passes the customer Phone number that was read for Customers.TXT
	 */
	public Customer(int customerID, String customerSurname, String customerFirstName, String customerPhoneNumber, String customerAddress, String customerSuburb, 
					String customerPostCode, ArrayList<Integer> joinArray) {
		
		this.customerID = customerID;
		this.customerSurname = customerSurname;
		this.customerFirstName = customerFirstName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerAddress = customerAddress;
		this.customerSuburb = customerSuburb;
		this.customerPostCode = customerPostCode;
		this.joinArray = joinArray;
		
	}
	

	/**
	 * @return the cIndex returns the value used as an index reference for an arrarList used in many methods in the main program
	 */
	public int getcIndex() {
		return cIndex;
	}
	/**
	 * @param cIndex sets an index for an element in an arrayList
	 */
	public void setcIndex(int cIndex) {
		this.cIndex = cIndex;
	}
	/**
	 * @return the joinArray returns just the customer IDs read from Cstomers.txt
	 */
	public ArrayList<Integer> getJoinArray() {
		return joinArray;
	}
	/**
	 * @return the customerID returns the customer ID for a particular element that was read from customers.txt 
	 */
	public int getCustomerID() {
		return this.customerID;
	}

	/**
	 * @return the customerSurname returns the customer Surname for a particular element that was read from customers.txt 
	 */
	public String getCustomerSurname() {
		return this.customerSurname;
	}

	/**
	 * @return the customerFirstName returns the customer First name for a particular element that was read from customers.txt 
	 */
	public String getCustomerFirstName() {
		return this.customerFirstName;
	}

	/**
	 * @return the customerAddress returns the customer Address for a particular element that was read from customers.txt 
	 */
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	/**
	 * @return the customerSuburb returns the customer Suburb for a particular element that was read from customers.txt 
	 */
	public String getCustomerSuburb() {
		return this.customerSuburb;
	}

	/**
	 * @return the customerPostCode returns the customer post-code for a particular element that was read from customers.txt 
	 */
	public String getCustomerPostCode() {
		return this.customerPostCode;
	}

	/**
	 * @return the customerPhoneNumber returns the customer Phone number for a particular element that was read from customers.txt 
	 */
	public String getCustomerPhoneNumber() {
		return this.customerPhoneNumber;
	}
	
	
	/**
	 * this method is used to display the customers details 
	 * 
	 * @return the str returns the customers details used to display the information in the main program.  
	 */
	public String toString() {
													
		String str = "Customer Surname: " + this.customerSurname + "\n" + "Customer Address: " +  this.customerAddress + ", " + this.customerSuburb + ", " + this.customerPostCode + "\n";
		
		return str;
		
	}
	/**
	 * 
	 * @return the str returns the customers details used to display the information in the main program.  
	 */
	public String toString1() {
		
		String str = "Customer ID: " + this.customerID + "\n" + "Customer Name: " +  this.customerFirstName + " " + this.customerSurname + "\n"
					+ "Address: " + this.customerAddress + ", " + this.customerSuburb +  ", " + this.customerPostCode + "\n";
		
		return str;
		
	}
	
}
