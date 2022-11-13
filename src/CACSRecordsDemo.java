import java.io.File; 
import java.io.IOException;
import java.text.ParseException;
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

class CACSRecordsDemo {
	
	/**
	 * this method is used to extract all the people with the same surname in the customers arrayList. It will display the address and full name so that the user can clearly identify themselves
	 * and tell the program who they are. This is done from line 46 - 94. note: this method is used in the searchByCustomer method and will only execute if the number passed in the
	 * int num parameter is equal 2 (see line 361). 
	 * 
	 * @return a boolean true or false
	 */
	public static boolean listSameSurname(ArrayList<Integer> temp1, ArrayList<Customer> customerFile, Menu m, int num, Bookings b, 
											ArrayList<Bookings> bookingsList, ArrayList<Service> serviceFile) throws ParseException {
		
		ArrayList<Integer> temp2 = new ArrayList<>();
		int choice = 0;
		boolean error = true;
		String s = "";
		int newCId = 0;
		int compare = 0;
		
		/**
		 *as this method is passed an arrayList to extract information - if the arrayList size is equal to 1 - it tells the program that there is only 1 person with that surname and
		 *specific codes from lines 41 to 50 will execute. If the passed arrayList size is greater than 1, this tells the program that there is more than 1 person with the same surname
		 *and will execute the code related to that condition. see lines 56 - 103. 
		 */
		
		if (temp1.size() == 1 ) {
			
			newCId = customerFile.get(temp1.get(0)).getCustomerID();
			b.setCustomerID(newCId);
			b.setCustomerID(newCId);
			s = Dates.requstDate(m);
			s = Dates.dateAvail(bookingsList, s);
			b.setDate(s);
			listServices(serviceFile);
			error = false;
		}
		
		if (temp1.size() > 1 ) {
				
			System.out.println("\nThe following people have been identified with the same Surname in the System: \n");
			
			for(int i = 0; i < temp1.size(); i++) {
				
				newCId = customerFile.get(temp1.get(i)).getCustomerID();
				temp2.add(newCId);
				System.out.println(customerFile.get(temp1.get(i)).toString1());
				
			}
			
			//this block of code will get the user to continuously enter an id until they get it right for greater data integrity. 
			
			choice = m.requestMenuChoice("Please enter one of the above listed customer ID's that identify's with your exact details: ");
			
			while (error == true) {
				
				for(int i = 0; i < temp2.size(); i++) {
					
					compare = temp2.get(i);
					
					if (choice == compare) {
						error = false;
					}
				}
				
				if (error == false) {
					
					b.setCustomerID(choice);
					s = Dates.requstDate(m);
					s = Dates.dateAvail(bookingsList, s);
					b.setDate(s);
					listServices(serviceFile);
				}
				
				else {
					choice = m.requestMenuChoice("\nThe Customer ID you entered was not indetified - please re-enter one of the above listed Customer ID's or press '0' to cancel.\n\nYour selection: ");
				}
				
				if(choice == 0 ) {
					break;
				}
			}
		}
		
		if (error == false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * This method adds all the details related to a new booking ie. new arrayList index, new customer id, the service codes the customer requires, new booking id.
	 * 
	 * 
	 * @param newIndex passes the new element index for a new booking
	 * @param newBId passes the new booking index for when the user makes a new booking
	 */
	public static void makeBookings(ArrayList<Bookings> bookingsList, Bookings bookingDetails, int newIndex, int newBId, ArrayList<Service> serviceFile, ArrayList<Integer> temp, 
									ArrayList<Customer> customerFile, Menu m) {
		
		newIndex = bookingsList.size();
		newBId = bookingDetails.getLargest() + Menu.ONE;
		bookingDetails.setLargest(newBId);
		bookingsList.add(newIndex, new Bookings());
		bookingsList.get(newIndex).setLargest(newBId);
		bookingsList.get(newIndex).setBookingID(newBId);
		bookingsList.get(newIndex).setCustomerID(bookingDetails.getCustomerID());
		bookingsList.get(newIndex).setDate(bookingDetails.getDate());
		ArrayList <Integer> nSCode = new ArrayList<>();
		int find = 0;
		temp = tempArray(serviceFile, bookingsList, customerFile, Menu.TWO);
		find = m.requestMenuChoice("\nPlease enter the Service codes you require: ");
		nSCode = m.newSCode(find, temp);
		bookingsList.get(newIndex).setServiceCodes(nSCode);
		
	}
	
	/**
	 * this method is used to print out the detailed service code information
	 */
	public static void listServices(ArrayList<Service> serviceFile) {
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Service Code\t\t\t\t\s\s\sService Name\t\t\t\t\t\t\t\t\s\s\sService Description");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < serviceFile.size(); i++ ) {
			
			System.out.println(serviceFile.get(i).toString());
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	
	}
	/**
	 * this method is used to set the amount (if accepted) in the bookings submenu
	 * 
	 * @param num
	 * @param f pass the fileProcessing object to the method
	 * @return a boolean true or false depending on the outcome of the interaction once the method is executed.
	 */
	public static boolean validateTrue(ArrayList<Bookings> bookingsList, Bookings bookingDetails, float num, FileProcessing f) throws IOException {
			
		bookingsList.get(bookingDetails.getbIndex()).setTrueOrFalse(false);
		
		if (num > bookingsList.get(bookingDetails.getbIndex()).getTenPercent()) {
			
			System.out.println("\n ** Approved ** ");
			
			//the boolean variable below will flag that the amount is approved and will be used later in the program to determine whether to set the new amount or not. (see line 293) 
			bookingsList.get(bookingDetails.getbIndex()).setTrueOrFalse(true);
			bookingsList.get(bookingDetails.getbIndex()).setTotalPrice(num);
			bookingsList.get(bookingDetails.getbIndex()).setDiscount(num);
			
			return true;
			
		} else {
			
			System.out.println("\n ** Denied ** ");
			System.out.println("\n*** The amount entered is greater than 10% - 10% is the maxium discount that is applicable ***");
			
			return false;
		}
		
	}
	//not implemented yet. trial method - test further(for my reference)
	public static void menuClass(Menu m, int choice) {
		
		choice = m.requestMenuChoice("\nPress 1: Display Booking Detail\nPress 2: Change Display Day\nPress 3: Set Fee\n"
				+ "Press 4: Exit Sub-menu\n\nYour selection: ");
		
		m.setDisplay(choice);
		
	}
	
	/**
	 * this method will display the modified details once changes have been made 
	 */
	public static void displayModified(ArrayList<Customer> customerFile, ArrayList<Service> serviceFile, ArrayList<Bookings> bookingsList, ArrayList<Integer> temp,
			Bookings bookingDetails, Customer customerDetials) {
		
//		float tenPercent = 0;
		
		System.out.println("\n*** Booking Details ***\n");
		System.out.println(bookingsList.get(bookingDetails.getbIndex()).toString1());
		System.out.println(customerFile.get(customerDetials.getcIndex()).toString());
		temp = tempArray(serviceFile, bookingsList, customerFile, Menu.TWO);
		searchServiceCodes(temp, bookingsList, serviceFile, bookingDetails.getbIndex());
		
	}
	
	/**
	 * This method will display the bookingsList arrayList in a detailed format 
	 * 
	 * @param m passes the menu object as a parameter
	 * @param customerFile passes the customerFile arrayList as a parameter
	 * @param serviceFile passes the serviceFile arrayList as a parameter
	 * @param bookingsList passes the bookingsList arrayList as a parameter
	 * @param temp passes the temp arrayList as an argument
	 */
	public static void displayFullDetails(Menu m, ArrayList<Customer> customerFile, ArrayList<Service> serviceFile, ArrayList<Bookings> bookingsList, ArrayList<Integer> temp,
			Bookings bookingDetails, Customer customerDetials) {
		
		int b_Index = 0;
		int c_Index = 0;
		int find = 0;
		
		/**
		 * In this block of code the tempArray method returns an arrayList that is passed to the search Method. In that method the code iterates through the temp arrayList and 
		 * assigns an index in the bookingsList arrayList that will be used to pick out a singular element from that arrayList. Depending on the number that is passed as an argument
		 * in the temArray method, will determine the type of search in that method. 1 = Customers arrayList, 2 = service arrayList and 3 = Bookings arrayList.  
		 * 
		 * the results are then displayed using a toString method created in each class.
		 */
		
		//search and display for the bookings
		temp = tempArray(serviceFile, bookingsList, customerFile, Menu.THREE);
		find = m.requestMenuChoice("Please enter Booking Id: ");
		b_Index = m.search(find, temp);
		bookingDetails.setbIndex(b_Index);										//here the booking index is set in the bookings object for future use in the program.
		System.out.println("\n*** Booking Details ***\n");
		System.out.println(bookingsList.get(b_Index).toString1());
		
		//search and display for the customer details
		temp = tempArray(serviceFile, bookingsList, customerFile, Menu.ONE);
		c_Index = m.search(bookingsList.get(b_Index).getCustomerID(), temp);
		customerDetials.setcIndex(c_Index);
		System.out.println(customerFile.get(c_Index).toString());
		
		//search and display for the service details.
		temp = tempArray(serviceFile, bookingsList, customerFile, Menu.TWO);
		searchServiceCodes(temp, bookingsList, serviceFile, b_Index);
		
	}
	/**
	 * this method is used to find the service codes in each element of the bookingsList arrayList and display the content in detail. It will display total price of all the services codes,
	 *  the name and the description.
	 * 
	 * @param temp passes temp arrayList created to stores each service code in each element of the bookingsList arrayList
	 * @param bookingsList passes bookingsList arrayList
	 * @param serviceFile passes serviceFile arrayList
	 * @param b_Index passes the bookingList index obtained from the search method created in the menu class.
	 */
	public static void searchServiceCodes(ArrayList<Integer> temp, ArrayList<Bookings> bookingsList, ArrayList<Service> serviceFile, int b_Index) {
		
		int first = 0;						//created to store values for the first of 2 array list that are used in this method
		int second = 0;						//created to store the values for the Second of 2 array list that are used in this method
		int marker = 0;						//used to indicate index of where the match was found in the bookingsList arrayList.
		float priceTotal = 0f;				//Created to store the total value of each service code in the bookingsList arrayList.
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Service\t\t\s\s\s\s\s\s\s\s\s\s\s\s\sService Name\t\t\tService Price");
		System.out.println("code(s)");
		System.out.println("-------------------------------------------------------------------------------");
		
		
		while(marker < bookingsList.get(b_Index).getServiceCodes().size()) {

			first = bookingsList.get(b_Index).getServiceCodes().get(marker);          //the services codes from the bookingsList arrayList.
			marker++;
			
			for(int j = 0; j < temp.size(); j++) {
				
				second = temp.get(j);				//all service codes from serviceFile arrayListist							
		
				if(first == second) {				// this code matches each booking id from the first and second arrayList, adds the price in each iteration and executes the following codes
					
					priceTotal += serviceFile.get(j).getServicePrice();
					System.out.printf("%-8d\t%-40s\t$%-20.2f\n", first, serviceFile.get(j).getServiceName(), serviceFile.get(j).getServicePrice()); 
					break;
					
				}				
			}
		}
		
		//this code will set the approved discount.  
		if (bookingsList.get(b_Index).isTrueOrFalse() == true) {
			bookingsList.get(b_Index).setTotalPrice(bookingsList.get(b_Index).getDiscount());
		
		//if the price is not approved than the original total that was calculated will be stored. 
		} else {
			bookingsList.get(b_Index).setTotalPrice(priceTotal);
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.printf("\t\t\t\t\t\t\s\s\sTotal Price: $%-20.2f\n", bookingsList.get(b_Index).getTotalPrice());
	}
	
	/**
	 * this method creates a temp array used to store the primary keys from each file. 1. customer id, 2. service id, 3. bookings id. 
	 * Depending on the condition determines how the method reacts.
	 * 
	 * @param serviceFile passes the serviceFile
	 * @param bookingsList passes the bookingsList
	 * @param customerFile passes the customerFile
	 * @param number is passes the condition the method will execute.
	 * @return an the temp arrayList
	 */
	public static ArrayList<Integer> tempArray(ArrayList<Service> serviceFile, ArrayList<Bookings> bookingsList, ArrayList<Customer> customerFile, int number) {
		
		ArrayList<Integer> temp = new ArrayList<>();
		int joiner = 0;										//stores the primary for each array list.
		int length = 0;										//stores the length of each array list
		
		if(number == Menu.ONE) {
			length = customerFile.get(0).getJoinArray().size();
		}
		
		if(number == Menu.TWO) {
			length = serviceFile.get(0).getJoinArray().size();
		}
		
		if(number == Menu.THREE) {
			length = bookingsList.size();
		}
		
		for (int i = 0; i < length; i++) {									//a for loop to iterate through the arryList depending on the conditional statement.
			
			if(number == Menu.ONE) {
				
				joiner = customerFile.get(0).getJoinArray().get(i);
				temp.add(i, joiner);
			}
			
			if(number == Menu.TWO) {
				
				joiner = serviceFile.get(0).getJoinArray().get(i);
				temp.add(i, joiner);
			}
			
			if(number == Menu.THREE) {
				
				joiner = bookingsList.get(i).getBookingID();
				temp.add(i, joiner);
			}
		}
		
		return temp;
	}
	/**
	 * this method validates the users input to match the data in the bookings array list, checks for date availability and request the service codes the user 
	 * requires. You will notice that i've combined the search by number and the search by surname in the same method. Depending on what the int num parameter is, determines the search.
	 * 1: will be a search by number, 2: will be a search by surname. this method can be found on line 630. 
	 * 
	 * @param serviceFile passes the serviceFile arrayList
	 * @param bookingsList passes the bookingsList arrayList
	 * @param customerFile passes the customersFile arrayList
	 * @param number passes the number for the condition inside the method
	 * @param b passes the Bookings object
	 * @param str passes the string address from the user's input in the previous method
	 * @return a boolean true or false
	 * @throws ParseException for the date format
	 */
	public static boolean searchByCustomerDetails(ArrayList<Customer> customerFile, int num, String str, ArrayList<Bookings> bookingsList, ArrayList<Service> serviceFile, Bookings b, String ms) throws ParseException {
		
		ArrayList<String> temp = new ArrayList<>();
		Menu m = new Menu();
		String s = "";
		int counter = 0;
		boolean noMatch = true;
		int newCId = 0;
		ArrayList<Integer> temp1 = new ArrayList<>();
		
		/**
		 * step 1: depending which condition is passed (1: search by number or 2: search by surname) the for loop performs a search through the customerFile arrayList.
		 *	which is then stored in (str1).
		 */ 			
		for (int i = 0; i< customerFile.size(); i++) {
			String str1 = "";
			
			//if the user is searching by a phone number
			if (num == Menu.ONE) {
				str1 = customerFile.get(i).getCustomerPhoneNumber();
			}
			
			//if the user is searching by surname 
			if (num == Menu.TWO) {
				str1 = customerFile.get(i).getCustomerSurname();
			}
			
			//counts each iteration of the for loop
			counter++;
			
			//Step 2 if address of str equals str1 the following codes are executed 
			if(str.equals(str1)) {		
				
				//this code stores into index which iteration of the for loop the above condition is met. this will be the index at which element of the arrayList the match was found.
				int index = counter - 1;
				
				/**
				 * if condition is (number == 2) the method starts by adding the index to temp1 array list to where a match was found in the customersFile arrayList. Temp1 will
				 * be used to display each match through each iteration of the for loop.
				 */
				if(num == Menu.TWO){
					temp1.add(index);
				}
				
				//the following codes are executed for the search by number
				else {
					
					newCId = customerFile.get(index).getCustomerID();
					
					//this code sets the customer id for the new element of the bookingsFile arrayList into the Bookings b object. This id will be retrieved later in the program.
					b.setCustomerID(newCId);
					
					//this method request the user to enter a date. once the date format has been validated it then passes the string s address to check availability 
					s = Dates.requstDate(m);
					
					// availability is then checked in this method and validated to make sure the user does not enter today's date, a date in the bookings arrayList and a date before today's date.
					s = Dates.dateAvail(bookingsList, s);
					
					//once a date has been accepted , it is then set in the Bookings b object, to be retrieved later in in the program
					b.setDate(s);
					
					//this  code will display all the service codes and get the user to enter services that they require.
					listServices(serviceFile);
					
					//once the sequence is completed noMatch will equal false and will break out of the for loop.
					noMatch = false;
					break;
					
				}
			}
		}
		
		if(num == Menu.TWO){
			
			//this method takes temp1 as an argument and will display or the multiple surnames found, if found. 
			noMatch = listSameSurname(temp1, customerFile, m, num, b, bookingsList, serviceFile);
		}
		
		if (noMatch == true) {
			
			//if a match was not found noMatch will return true 
			System.out.println(ms);
			return true;
		}
		else {
			
			return false;
		}
	
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		
		Scanner kb = new Scanner(System.in);
		FileProcessing f = new FileProcessing ();							
		ArrayList<Customer> customerFile = new ArrayList<>(); 					
		Customer customerDetials = new Customer();
		ArrayList<Service> serviceFile = new ArrayList<>(); 
		Service serviceDetails = new Service ();
		ArrayList<Bookings> bookingsList = new ArrayList<>(); 
		Bookings bookingDetails = new Bookings();
		Menu m = new Menu ();
		ArrayList<Integer> temp = new ArrayList<>();
		int choice = 0; 													//used to store menu choice
		boolean noMatch = true;												//used to return a value true or false to determine an outcome
		boolean valAndsetD = false;											//used in a method to flag if a users interactions with the program is true or false.
		int bookingCounter = 0;												//used to count the number of iterations in a loop to determine an outcome
		
		
		
		//these codes will read customers.txt and service.txt 
	 	f.readCustomerFile(customerFile, customerDetials);
		f.readServiceFile(serviceFile, serviceDetails);
		
		//this codes displays a menu and stores the users input into the choice variable.
		choice = m.requestMenuChoice("**** Welcome to the CACS database ****\n\nPress 1: Process Booking file\nPress 2: Exit program\n\nYour selection: ");		
		
		while (choice > Menu.TWO || choice < Menu.ONE) {
			
			System.out.println("\n** Incorrect input. You must enter either the number 1 or 2**");
			
			choice = m.requestMenuChoice("\n**** Welcome to the CACS database ****\n\nPress 1: Process Booking file\nPress 2: Exit program\n\nYour selection: ");	
		}
		
		//the following codes will execute while variable choice is not equal to 2. once the user enter 2 the program will terminate
		while (choice != Menu.TWO) {	
			
			//if choice is equal to one the following codes will execute
			if(choice == Menu.ONE) {
				
				/**
				 * this code is a method from the fileProcessing class. These codes will request the user to enter a file name. The code has been written
				 * to validate if the file exist or not. If it dosen't the user has the option to terminate the whole program. If the file exists the loop will
				 * terminate in the method and the filename will be set in the Bookings object for future use later in the program.
				 */
				f.bookingFiles(bookingDetails, bookingsList);
				bookingDetails.setbFile(f.getbFile());					//here is where the filename is set
				
			}
			
			//this code will execute if the user chooses to terminate the program. The boolean completelyTerminate will equal true. 
			if (f.isCompletelyTerminate() == true) {
				
				//this breaks the code out of the first loop and the program is terminated by an if statement on line 668
				break;
			}
			
			//the following code will execute if the file was found
			else {
				
				//this code is from the Menu class. this will display the bookings menu created in the Menu class.
				m.bookingsMenu(bookingDetails, bookingsList, f);
				
				/**
				 * the following code will continue to execute until the field variable getBookingsOption is not equal to three. note: Option 2 for 
				 * 	this menu starts at line 597.
				 */
				while(m.getBookingsOption() != Menu.THREE) {
					
					//if the user enters one the following codes will execute
					if(m.getBookingsOption() == Menu.ONE) {
						
						//this code displays the bookings file in a table format used by the toString methods created in the class
						m.Displaybookings(bookingsList);
						
						/**
						 * once the items have been displayed the user will then be automatically entered into the bookings submenu created in the menu class.
						 * Please see menu class for specific details of the method.
						 */
						m.submenu(choice);
						
						while(m.getSubMenuOption() == Menu.THREE || m.getSubMenuOption() == Menu.TWO) {
							
							System.out.println("\n** You must 'Display Booking Detail (option 1)' before setting a fee or changing dates **");
							
							m.submenu(choice);
						}
						
						// the following code will continue to execute until the field variable getSubMenuOption is not equal to four.
						while(m.getSubMenuOption() != Menu.FOUR){
							
							// if the user enters 1 it allow the user to display detailed booking information and the following codes will execute.
							if (m.getSubMenuOption() == Menu.ONE) {
								
								System.out.println("");
								//this code will display the detailed information for a specific bookings id
								displayFullDetails(m, customerFile, serviceFile, bookingsList, temp, bookingDetails, customerDetials);
								
							}
							
							//if the user enters 2 it will allow the user to modify a date and the following codes will execute
							if (m.getSubMenuOption() == Menu.TWO) {
								
								String str1 = "";				//used to take the user input for the date
								
								/**
								 * the following codes will request a date from a method created in the dates class and then pass the string address "str1"
								 * to be set in the bookingsList arrayList. it will then display the modified date.
								 */
								str1 = Dates.requstDate(m);
								bookingsList.get(bookingDetails.getbIndex()).setDate(str1);
								displayModified(customerFile, serviceFile, bookingsList, temp, bookingDetails, customerDetials);
								noMatch = false;
								
							}
							
							/**
							 * if the user enters 3, it will allow the user to set a specific amount. The amount must not be greater than 10% less the total price
							 */
							if (m.getSubMenuOption() == Menu.THREE) {
								
								float tenPercent = 0f;     				//used to take the users float input 
									
									/**
									 * the following codes will request an amount from a method created in the menu class. The program will then validate if the
									 * amount is applicable or not. The validateTrue method will then set valAndsetD boolean to either true or false. 
									 * The outcome (true or false) will then determine how the code operates on line 610. 
									 */
									tenPercent = m.requestFloat("\nEnter ammount: ");
									valAndsetD = validateTrue(bookingsList, bookingDetails, tenPercent, f);
									noMatch = false;
								
							}
							
							//if the user enters four, the program simply exists the sub menu and enter the bookings menu, where further options can be chosen.
							if (m.getSubMenuOption() == Menu.FOUR) {	
								break;
							}
							
							/**
							 * this code will re-enter the user into the submenu after they: 1 display details, 2 change date or 3 set amount. 
							 * they can also choose to continuously make changes in the submenu or press 4 to break them out of the sub menu. 
							 */
							m.submenu(choice);
						///in sub-option while loop (for my reference)
						}
						
					//last spot in get-bookings option 1 (for my reference)
					}
					//outside of get-option one (for my reference)
					
					
					//if user enter 2, it allows them to make a booking by either entering the surname or phone number.
					if(m.getBookingsOption() == Menu.TWO) {
						
						/**
						 * these next codes prepares the program to add multiple elements to the existing bookingsList arrayList.
						 * 
						 * the array list size is used for the new element of the arrayList to make the booking. This code is dynamic as it will always assign
						 * the size() of the new element no matter how big/small the arrayList is. if the user enter this option multiple times, it will always scale
						 * accordingly.
						 */
						int newIndex = bookingsList.size();
						
						/**
						 *  Since the largest number is always stored in the last element of the arrayList from the fileProcressing class - Size() is not the right number to retrieve that number
						 *  as the first element of the arrayList will always be 0. -1 was added so that the program always looks in the true last element of the 
						 *  arrayList. Once the the largest number is retrieved, it is then set in the Bookings object for future use later in the program. 
						 *  largest number will be used for the new booking ID by adding 1 for each iteration when the user makes a booking. 
						 */
						int newBId = bookingsList.get(newIndex-1).getLargest();
						bookingDetails.setLargest(newBId);								//largest number is set here
						
						//here the user is presented with a menu.
						int menuNum = m.requestMenuChoice("\nPress 1: By Number\nPress 2: By Surname\nPress 3: Exit Sub-menu\n\nYour selection: ");
						
						//the following codes will continue to execute if menuNum does not equal 3
						while (menuNum != Menu.THREE) {
							
							//this allows the user to do a search by mobile number
							if (menuNum == Menu.ONE) {
								
								//str stores the users input for the phone number. Str is then passed as an argument for the search by customer detail.
								String str = m.requestFile("\nEnter a mobile number: ");
								
								//if the there is no match from str, the boolean noMatch will return true and then line 637 is executed.
								noMatch = searchByCustomerDetails(customerFile, Menu.ONE, str, bookingsList, serviceFile, bookingDetails,"\n** The phone number you entered had no match in the system **");								
								
								/**
								 *  if no match returns false. the following codes are executed.
								 */
								if(noMatch == false) {
									
									//the variable booking counter ensures that the user enters at least one service code
									bookingCounter++;
									
									//make booking finalizes the the booking by validating a date and requesting services the user requires 
									makeBookings( bookingsList, bookingDetails,  newIndex,  newBId, serviceFile, temp, customerFile,  m);
									break;
								}
								
								else {
								}
							}
							
							/**
							 * option 2 is the surname search. the same sequence of checks occur exactly like option one. the only difference is that the 
							 * the surname search displays the surnames found if more than one person has the same surname. 
							 */
							if (menuNum == Menu.TWO) {
								
								String str = m.requestFile("\nEnter your Surname: ");
								
								noMatch = searchByCustomerDetails(customerFile, Menu.TWO, str, bookingsList, serviceFile, bookingDetails,"\n** The Surname you entered had no match in the system **");
								
								if(noMatch == false) {
									
									bookingCounter++;
									makeBookings( bookingsList, bookingDetails,  newIndex,  newBId, serviceFile, temp, customerFile,  m);
									break;
								}
								
								else {
								}
								
							}
							
							//this code will be used to determine if any changes have been made to prompt the save or cancel option on line 697
							if (bookingCounter > 0) {
								noMatch = false;
							}
							
							/**
							 * if no match is found the user will always be given the option in this menu to keep searching by name or number until they enter 3, 
							 * which will take them to the submenu.
							 */
							menuNum = m.requestMenuChoice("\nPress 1: By Number\nPress 2: By Surname\nPress 3: Exit Sub-menu\n\nYour selection: ");
						}
					}
					
					if(m.getBookingsOption() == Menu.THREE) {
						break;
					}
					
					//this code is part of the second while loop and will be displayed after a user finishes with a menu option
					m.bookingsMenu(bookingDetails, bookingsList, f);
					///in the get-options while loop(for my reference)
				}
			
				if(m.getBookingsOption() == Menu.THREE) {
					
					
					String saveOrCan = "";						//this stores the string address if the user wants to save or cancel changes.
					
					if (noMatch == false || valAndsetD == true) {
						
						 //this code will give the user the opportunity to save or cancel the changes.
						 saveOrCan = m.requestStringOption("\n*** WARNING ***\n\nChanges have been made to the booking(s)\n\nPress 's' to SAVE changes or 'c' to CANCEL changes\n\nYour Selection: ");
					}
					
					if(saveOrCan.equalsIgnoreCase("c")) {
						
						//these codes terminate the program without saving the changes.
						choice = 2;
						break;
					}
					
					//this code saves the changes
					else {
						
						String str = bookingDetails.getbFile();
						f.editFile(bookingsList, str);
						choice = 2;
						break;
					}
				}
			///outside of original else	(for my reference)
			}
			
			//in the while option = 2(for may reference)
		}
		
		//if any of these conditions are met then the program will terminate.
		if (f.isCompletelyTerminate() == true || choice == Menu.TWO || m.getBookingsOption() == Menu.FOUR) {
			
			System.out.println("\n*** The program has been terminated, Have a great day/afternoon/night. ***");
		}
	}
}


		
		



