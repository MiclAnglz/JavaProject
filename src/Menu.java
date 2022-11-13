import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */
public class Menu {
	
	private String fileName;									//stores the file name used to save changes to the bookingslist
	private int option;											//stores the menu option chosen by the user
	private int inuptOption;
	private float finput;//stores the input option chosen by the user
	private boolean terminate;									//flags that the user wishes to terminate the program
	private int bookingsOption;									//Stores the menu option for the bookings menu
	private FileProcessing fP = new FileProcessing ();
	final int MAIN_MENU_TERMINATE_ENTRY = FOUR;					
	final int BOOKING_MENU_TERMINATE_ENTRY = FOUR;
	final int EXIT_BOOKING_MENU = -2;
	
	// lines 28 -34 are static variables used to indicated menu preferences and more.
	final static int ONE = 1;
	final static int TWO = 2;
	final static int THREE = 3;
	final static int FOUR = 4;
	final static int FIVE = 5;
	final static int ZERO = 0;
	private int display;									//stores an integer value to display
	private int subMenuOption;								//stores the menu option for the submenu
	private float modifiedPrice;							//stores the modified price
	private String bFile;									//stores the booking file name.
	
	
	/**
	 * @return the bFile returns the bookings file name
	 */
	public String getbFile() {
		return bFile;
	}

	/**
	 * @param bFile passes the bFile to set booking file name
	 */
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	/**
	 * @return the modifiedPrice returns the modified price if accepted
	 */
	public float getModifiedPrice() {
		return modifiedPrice;
	}
	
	/**
	 * @param display passes the display to set the integer value to display
	 */
	public void setDisplay(int display) {
		this.display = display;
	}

	/**
	 * @param option passes the option to set the option choice
	 */
	public void setOption(int option) {
		this.option = option;
	}

	/**
	 * @return the subMenuOption gets the sub menu option choice from the user
	 */
	public int getSubMenuOption() {
		return subMenuOption;
	}

	/**
	 * @return the display the integer to be displayed
	 */
	public int getDisplay() {
		return display;
	}

	/**
	 * @return the inuptOption returns input option from the user
	 */
	public int getInuptOption() {
		return inuptOption;
	}

	/**
	 * @return the fileName that was processed
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * @return the option choice from the user
	 */
	public int getOption() {
		return this.option;
	}

	/**
	 * @return the terminate true or false depending on the interaction from the user. 
	 */
	public boolean isTerminate() {
		return this.terminate;
	}

	/**
	 * @return the bookingsOption chosen by the user
	 */
	public int getBookingsOption() {
		return this.bookingsOption;
	}

	/**
	 * @return the fP object used to process the file. this will be used for the edit file method
	 */
	public FileProcessing getfP() {
		return this.fP;
	}

	/**
	 * This code is used to capture the user's input for the file needed to be read.
	 * 
	 * @param m - passes the string address to instruct the user on what to input.
	 * @return str - returns the str address based on the user's input.
	 */
	public int requestMenuChoice(String m) {
			
		Scanner kb = new Scanner (System.in);
		boolean error = true;
		int num = 0;
		
		while(error == true) {
			
			try {
				
				System.out.print(m);
				this.inuptOption = kb.nextInt();	 
				error = false;
				
			} catch (InputMismatchException e) {
				
				kb.next();
				
				System.out.println("\n** Incorrect input. You must enter a whole number **");
				
			}
			
		}
		
		return this.inuptOption;		
	}
	/**
	 * 
	 * @return a float value
	 */
	public float requestFloat(String m) {
		
		Scanner kb = new Scanner (System.in);
		boolean error = true;
		
		while(error == true) {
			
			try {
				
				System.out.print(m);
				this.modifiedPrice = kb.nextFloat();
				error = false;
				
			} catch (InputMismatchException e) {
				
				kb.next();
				
				System.out.println("\n** Incorrect input. You must enter a whole number **");
				
			}
			
		}
		return this.modifiedPrice;	 			
	}
	
	/**
	 * @return the fileName being processed
	 */
	public String requestFile(String m) {
		
		Scanner kb = new Scanner (System.in);
		System.out.print(m);
		this.fileName = kb.nextLine();	
		
		return this.fileName;	
	}
	
	/**
	 * 
	 * @return a string inputed by the user
	 */
	public String requestStringOption(String m) {
		
		Scanner kb = new Scanner (System.in);
		System.out.print(m);
		this.fileName = kb.nextLine();	
		
		return this.fileName;	
	}
	
	// this is a header for a display method used in the main program
	public void Displaybookings(ArrayList<Bookings> bookingsList) {
		
		System.out.println("\n-------------------------------------------------------------------------------------------------");
		System.out.println("Date\t\tBooking_ID\tCustomer_ID\tTotal Price\t\s\s\s\s\s\s\s\s\s\sService Codes");
		System.out.println("-------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i <bookingsList.size(); i++ ) {
			System.out.println(bookingsList.get(i).toString());
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------");
	}

	/**
	 * this method is used in the main program to enter the user into the bookings menu
	 */
	public void bookingsMenu(Bookings b, ArrayList<Bookings> bookingsList, FileProcessing f){
		
		this.bookingsOption = requestMenuChoice("\n*** Bookings Menu ***\n\nPress 1: Display Bookings\nPress 2: Make a Booking\nPress 3: Exit Program\n\nYour selection: ");
		
		while (this.bookingsOption != Menu.THREE) {
		
			if (this.bookingsOption == ONE) {
				break;
			}
			
			if (this.bookingsOption == TWO) {
				break;				
			}
				
			this.bookingsOption = requestMenuChoice("\n*** Please make another selection ***\n\nPress 1: Display Bookings\nPress 2: Make a Booking\nPress 3: Exit Program\n\nYour selection: ");
		}
	}
	
	/**
	 * this method is used in the main program to enter the user into the bookings submenu menu
	 * 
	 * @param subMenuOption passes the submenu option inputed by the user
	 */
	public void submenu(int subMenuOption) {
		
		this.subMenuOption = requestMenuChoice("\nPress 1: Display Booking Detail\nPress 2: Change Display Date\nPress 3: Set Fee\n" + "Press 4: Exit Sub-menu\n\nYour selection: ");
		
		while(this.subMenuOption != FOUR) {
			
			// This will display a booking detail
			if(this.subMenuOption == ONE) {
				break;
			}
			
			if(this.subMenuOption == TWO) {
				break;
			}
			
			if(this.subMenuOption == THREE) {
				
				
				break;
			}
			
			System.out.println("\n*** enter a number from 1 - 4 ***");  
			
			this.subMenuOption = requestMenuChoice("\nPress 1: Display Booking Detail\nPress 2: Change Display Date\nPress 3: Set Fee\n"
													+ "Press 4: Exit Sub-menu\n\nYour selection: ");

		}
	}

	/**
	 * this method is used to indicate a specific index in any of the arrayList created.
	 * 
	 * @param find passes the primary key to be compared with the data from the certain arrayList. note: is method is used to search through multiple arrayList. 
	 * @param temp
	 * @return the index for a specific element in the bookings list
	 */
	public int search(int find, ArrayList<Integer> temp) {
		
		int counter = 0;
		int index = 0;
		boolean found = false;
		
		
		while (found == false) {
			
			for(int i = 0; i < temp.size(); i ++) {
				
				int compare = temp.get(i);
				counter++;
				
				if (find == compare) {

					index = counter - 1; 
					found = true;
					break;
				}
			}
			
			counter = 0;
			
			if (!found) {
				
				found = false;
				find = requestMenuChoice("\nBooking Id was not indetified - please re-enter booking ID: ");

			}
		}
	
		return index;
	}
	
	/**
	 * this method is used when making a new booking. It will display the name and the code for every service in the service.txt and give the user the option to choose 
	 * which service they require. This code also validates that the user enters and saves at least 1 service code. This can be seen in lines 356 - 362. The method uses the counter 1
	 * variable to see how many times a user enters a service code. If counter1 == 0 - it tells the program that the user has not yet entered a service and will continue to ask the user to 
	 * enter one through a loop. The user will only break out of the look once counter1 > 0.  
	 * 
	 * @return all the service codes required for a new booking
	 */
	public ArrayList<Integer> newSCode(int find, ArrayList<Integer> temp) {
		
		ArrayList<Integer> newSCodes = new ArrayList<>();
		int counter = 0;
		int index = 0;										//stores the index of a specific element
		boolean found = false;								//flag the program that a match has been found
		int code = 0;										//stores the service code 
		int counter1 = 0;									//stores the number of iterations and also used to indicate whether the user has entered a service code of not.
		
		while (found == false) {
			
			while (find != 0) {
				
				found = false;
				
				for(int i = 0; i < temp.size(); i ++) {
					
					int compare = temp.get(i);
					counter++;
					
					if (find == compare) {
						
						index = counter - 1;
						code = temp.get(index);
						newSCodes.add(counter1, code);
						counter1++;
						found = true;
						break;
						
					}
				}
				
				counter = 0;
				
				if(found == true) {
					find = requestMenuChoice("\nPlease enter another service code or press '0' to quit\n\nYour selection: ");
				}
				
				else {
					find = requestMenuChoice("\nThe service code you entered was not indetified - please re-enter one of the above listed service codes or press '0' to exit\n\nYour selection: ");
				}
				
				if(counter1 == 0) {
					
					find = requestMenuChoice("\nYou must ener at least 1 service code - please re-enter one of the above listed service codes.\n\nYour selection: ");
					
					while (find == 0) {
						find = requestMenuChoice("\nYou must ener at least 1 service code - please re-enter one of the above listed service codes.\n\nYour selection: ");
					}
				}
			}
			
			counter = 0;
				
			if(find == 0) {
				break;
			}
		}
	
		return newSCodes;
	}
	
}
