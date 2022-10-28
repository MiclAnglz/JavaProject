import java.io.File;  
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
 
/**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */

public class FileProcessing {
	
	private String fileName;										//Stores the file name inputed for the user.
	private boolean completelyTerminate;							//flags that the user wishes to completely terminate the program
	private boolean success;										//flags that a method was completed successfully. 									
	final String TERMINATE_STRING = "t";							//Constant string value used to indicate the termination of the program
	final String ZERO_STRING = "0";									//Constant 0 value used for blank entries in the file.
	private String bFile;											//used to store the name of bookings file currently being read 
	private File bookingsFile;										//A file object to to read a txt file.
	
	
	/**
	 * @param sets the value for the completelyTerminate boolean 
	 */
	public void setCompletelyTerminate(boolean completelyTerminate) {
		this.completelyTerminate = completelyTerminate;
	}

	/**
	 * @return the bookingsFile returns the bookingsFile object 
	 */
	public File getBookingsFile() {
		return bookingsFile;
	}

	/**
	 * @param bookingsFile the bookingsFile to set the name of the bookings file object
	 */
	public void setBookingsFile(File bookingsFile) {
		this.bookingsFile = bookingsFile;
	}
	
	/**
	 * @return the bFile returns the name of the bookings file that is being read
	 */
	public String getbFile() {
		return bFile;
	}

	/**
	 * @param bFile the bFile to set the name of the booking file that is being read
	 */
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}

	/**
	 * @return the fileName returns the file name field variable 
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param success the success to set the success boolean variable
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the success returns the value of the success boolean variable
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the fullyTerminate returns the value of the completely terminate boolean variable 
	 */
	public boolean isCompletelyTerminate() {
		return this.completelyTerminate;
	}

	/**
	 * @return the fileName returns the file name inputed from the user.
	 */
	public String requestFile(String m) {
		
		Scanner kb = new Scanner (System.in);
		System.out.print(m);
		return this.fileName = kb.nextLine();	
		
	}
	
	/**
	 * used to store the primary keys in each file 
	 * 
	 * @param num1 passes the value parsed from the string token read from the txt files.
	 * @param num2	passes the index for the string token
	 * @param tokens passes the string values used to read data from the txt files
	 * @param joiner passes the primary key information from each file - eg. customer id referencing customers.txt
	 */
	public void joinerArray(int num1, int num2, String[] tokens, ArrayList<Integer> joiner) {
		
		num1 = Integer.parseInt(tokens[num2]);
		joiner.add(num1);
	}
	
	/**
	 * this codes is used to read customers.txt
	 * 
	 * @param customerList pass the content of the arrayList created to store the information read from Customers.txt.
	 * @param cus1 passes the object used for the arraList to store customer details.  
	 */
	public void readCustomerFile(ArrayList<Customer> customerList, Customer cus1) {
		
		Scanner kb = new Scanner (System.in);
		boolean error = true;											//boolean variable for a while loop to continuously execute until error is false 						
		int customerID = 0; 											//stores the customer Id
		String customerSurname = "";									//stores the customer Surname
		String customerFirstName = "";									//stores the customer First name
		String customerAddress= "";										//stores the customer Address
		String customerSuburb = ""; 									//stores the customer suburb
		String customerPostCode = "";									//stores the customer postcode
		String customerPhoneNumber = "";								//stores the customer Phone number
		int counter = 0;												//used to store the number of iterations in a loop
		ArrayList<Integer> joiner = new ArrayList<>();
		int num1;														//stores the index for the joiner arrayList
		
		
		//this code will continue to execute until the condition is false
		while (error == true) {
			
			try {
				
				File reader = new File("Customers.txt");
				Scanner file  = new Scanner(reader).useDelimiter(",|\\r\\n");
				
				// this code will read each token until it has reached eofl marker.
				while (file.hasNext()) {
					
					//these codes will read the data read from the file into the variables
					customerID = file.nextInt(); 
					customerSurname = file.next();
					customerFirstName = file.next();
					customerPhoneNumber = file.next();
					customerAddress= file.next();
					customerSuburb = file.next(); 
					customerPostCode = file.next();
					
					//these codes populate the elements of the joiner arrayList
					num1 = customerID;
					joiner.add(num1);
					
					//this codes initializes the object constructor 
					cus1 = new Customer(customerID, customerSurname, customerFirstName,  customerPhoneNumber, customerAddress, customerSuburb, 
							 customerPostCode, joiner);
					
					//this arrayList takes an object as parameter. the variables that were created above are then passed as arguments for the parameter of the constructor
					customerList.add(counter, new Customer(customerID, customerSurname, customerFirstName, customerPhoneNumber, customerAddress, customerSuburb, 
							 customerPostCode, joiner));
					
					//this code marks the index of each element of the arrayList
					counter++;
					
				}
				
				//this code will end the loop 
				error = false;
				
			}
			
			/**
			 * This code will catch the file not found exemption and will prompt a user to enter a file name that exists in the system.
			 * This code works in conjunction with the error boolean. If the error boolean remains true, then the code will 
			 * continue to execute until the users enter a file name that exists in the system. 
			 */
			catch (FileNotFoundException e) {
				
				System.out.println("\n*** File not found ***\n");
				this.fileName = requestFile("Please check for typos and re-enter file name - also check if the file exists in the system.\n\n *** or press 't' to terminate program ***\n\nYour input: ");
				
				//this code will flag that the customer wishes to terminate the program.
				if (this.fileName.equalsIgnoreCase(TERMINATE_STRING)) {
					
					this.completelyTerminate = true;
					break;
				}				
			}
		}
	}

	/**
	 * this codes is used to read Services.txt
	 * 
	 * @param serviceList passes the content of the serviceList arrayList
	 * @param serv passes the Services object
	 */
	public void readServiceFile(ArrayList<Service> serviceList, Service serv) {
		
		Scanner kb = new Scanner (System.in);						//needed for the scanner class
		boolean error = true;										//boolean variable for a while loop to continuously execute until error is false 
		int counter = 0;											//used to store the number of iterations in a loop  
		ArrayList<Integer> joiner = new ArrayList<>();				//initializing the arrayList used to store the primary keys in each file
			
		while (error == true) {
			
			try {
				
				File reader = new File("Services.txt");				//created to read services.txt
				Scanner file  = new Scanner(reader);				
				String str = "";									//created to store string addresses for data being read from Services.txt
				String [] tokens;									//created to store the data from the txt file.
				float price = 0f;									//stores the value of the price for a particular service
				int serviceCode = 0;								//Stores the services codes read from the services.txt
				String serviceName = "";							//stores the service name read from the file
				String serviceDescription = "";						//stores the service description read from the file.
				

				// this code will read each token until it has reached efln marker.
				while (file.hasNext()) {
					
					str = file.nextLine();							//will read the content of the txt file until reaches the line.
					tokens = str.split(",");						//this code delineates the using a ,
					
					
					//this code converts a string address in to a primitive data type.
					serviceCode = Integer.parseInt(tokens[Menu.ZERO]);
					
					//this codes is storing the primary keys from the txt file.
					joinerArray(serviceCode, Menu.ZERO, tokens, joiner);
					
					
					//this code will use the particular constructor created from the Services object if the length of the tokens array is less or equal to 3, 
					if(tokens.length <= Menu.THREE) {
						
						serv = new Service(serviceCode, serviceName, serviceDescription, joiner);
						serviceList.add(counter, new Service(serviceCode, tokens[Menu.ONE], tokens[Menu.TWO], joiner));
						counter++;
						
					}
					
					//this code will execute if the tokens array is greater than three and uses the constructor specifically created for this condition. 
					else {
						
						price = (float)Float.parseFloat(tokens[Menu.THREE]);
						
						serv = new Service(serviceCode, serviceName, serviceDescription, price, joiner);
						serviceList.add(counter, new Service(serviceCode, tokens[Menu.ONE], tokens[Menu.TWO], price, joiner));
						counter++;
				
					}
											
				}
				
				//this code will end the loop 
				error = false;
			
			}
			
			/**
			 * This code will catch the file not found exemption and will prompt a user to enter a file name that exists in the system.
			 * This code works in conjunction with the error boolean. If the error boolean remains true, then the code will 
			 * continue to execute until the users enter a file name that exists in the system. 
			 */
			catch (FileNotFoundException e) {
				
				System.out.println("\n*** File not found ***\n");
				this.fileName = requestFile("Please check for typos and re-enter file name - also check if the file exists in the system.\n\n *** or press 't' to terminate program ***\n\nYour input: ");
				
				
				//this code will flag that the customer wishes to terminate the program.
				if (this.fileName.equalsIgnoreCase(TERMINATE_STRING)) {
					
					this.completelyTerminate = true;
					break;
					
				}
			}
		}
	}
	
	/**
	 *this codes is used to read a bookings file
	 * 
	 * @param b1 passes the Bookings object as a parameter
	 * @param bookingsList passes the bookingsList arrayList as a parameter
	 */
	public void bookingFiles(Bookings b1, ArrayList<Bookings> bookingsList) {
		
		Scanner kb = new Scanner (System.in);
		boolean error = true;												//boolean variable for a while loop to continuously execute until error is false 
		int counter = 0;													//used to store the number of iterations in a loop  
		final int TOKEN_INDEX_MARKER = 4;									//A constant created to indicate the last element of the tokens array
		
		//this codes takes the users input and returns the string address to the bFile field variable
		this.bFile = requestFile("\nEnter Bookings File: ");
		
		//this code will execute until the condition in false
		while (error == true) {
			
			try {
				
				File reader = new File(this.bFile);
				Scanner file  = new Scanner(reader);
				String str = "";											//created to store string addresses for data being read from Services.txt
				String [] tokens;											//created to store the data from the txt file.
				int bookingID = 0;											//Stores the booking id read from the txt file
				int customerID = 0;											//stores the customer id read from the txt file
				String date = "";											//stores the date read from the txt file
				float totalPrice = 0f;										//stores the total price read from the txt file
				int servCodes = 0;											//stores the the service codes read from the txt file
				int largest = 0;											//stores the largest booking ID number read from the txt file
				ArrayList<Integer> joiner = new ArrayList<>();				//
				
				// this code will read each token until it has reached eoln marker.
				while (file.hasNext()) {
					
					ArrayList<Integer> serviceCodes = new ArrayList<>();
					str = file.nextLine();
					tokens = str.split(",");
					
					//this code stores the primary keys for the file (booking id)
					bookingID = Integer.parseInt(tokens[Menu.ZERO]);
					joinerArray(bookingID, Menu.ZERO, tokens, joiner);
					
					//this code will convert a null string address into a "0" and then parse it to a float variable.
					if (tokens[Menu.THREE].equals("")) {
						
						tokens[Menu.THREE] = ZERO_STRING;
						totalPrice = (float)Float.parseFloat(tokens[Menu.THREE]);
						
					}
						
						totalPrice = (float)Float.parseFloat(tokens[Menu.THREE]);
						
						//this code stores the largest number used to for the creating a new bookings id when the user wants to make a booking
						if (bookingID > largest ) {
							largest = bookingID;
						}
						
						customerID = Integer.parseInt(tokens[Menu.ONE]);
						
					/**
					 *  this codes will use TOKEN_INDEX_MARKER constant variable as a marker from the end on the tokens element. As there 
					 *  can be multiple service codes, the servCodes arrayList will store these values and then pass it as an argument for the specific 
					 *  object constructor. The code will only initiate in the tokens array size is greater than 5. This lets the program know that there
					 *  is more than 1 service code for a particular element of the tokens array.   
					 */
					if (tokens.length > Menu.FIVE) {
						
						int counter1 = 0;
						
						//here, 'i' will indicate every service code of the tokens array
						for (int i = 0; i < tokens.length - TOKEN_INDEX_MARKER; i++) {
							
							//  + 'i' enables the program to read every service code in the tokens array.
							str = tokens[TOKEN_INDEX_MARKER + i];
							servCodes = Integer.parseInt(str);
							
							//here the service codes are stored into the serviceCodes arrayList.
							serviceCodes.add(counter1, servCodes);
							
							//this code will indicate each element of the arrayList unit the for loop terminates.
							counter1++;
							
						}
						
						//In this part of the code the variables are passed as arguments to the constructor and the arrayList.
						b1 = new Bookings(bookingID, customerID, date, totalPrice, serviceCodes, joiner, largest);
						
						bookingsList.add(counter, new Bookings(bookingID, customerID, tokens[Menu.TWO], totalPrice, serviceCodes, joiner, largest));
						counter++;
										
					}
					
					//here if the tokens arrayList is less than the above condition, then the same code as above will still execute.
					else {
						
						//this code reset the counter.
						int counter1 = 0;
						
						for (int i = 0; i < tokens.length - TOKEN_INDEX_MARKER; i++) {
					
							str = tokens[TOKEN_INDEX_MARKER + i];
							servCodes = Integer.parseInt(str);
							
							serviceCodes.add(counter1, servCodes);
							counter1++;
							
						}
						
						b1 = new Bookings(bookingID, customerID, date, totalPrice, serviceCodes, joiner, largest);
						
						bookingsList.add(counter, new Bookings(bookingID, customerID, tokens[Menu.TWO], totalPrice, serviceCodes, joiner, largest));
						counter++;
						
					}
			
				}
			
				file.close();
				this.success = true;
				error = false;
			
			}
			
			/**
			 * This code will catch the file not found exemption and will prompt a user to enter a file name that exists in the system.
			 * This code works in conjunction with the error boolean. If the error boolean remains true, then the code will 
			 * continue to execute until the users enter a file name that exists in the system. 
			 */
			catch (FileNotFoundException e) {
				
				System.out.println("\n*** File not found ***\n");
				this.bFile = requestFile("Please check for typos and re-enter file name - also check if the file exists in the system.\n\n *** or press 't' to terminate program ***\n\nYour input: ");
				
				//this codes here flags that the user wishes to terminate the program.
				if (this.bFile.equalsIgnoreCase(TERMINATE_STRING)) {
					
					this.completelyTerminate = true;
					break;
					
				}
			}
			
			//this code here sets the file name for the file being processed to be able to retrieve it once modified information is need to be saved to a file.
			setbFile(this.bFile);
		}
	
	}
	/**
	 * this codes was inspired and modified from https://youtu.be/TpyRKom0X_s.
	 * 
	 * this code creates a new file, adds all the modified information onto it and then renames it to the file that was processed. This can only be done
	 * once the old file has been deleted. 
	 * 
	 * @param bookingsList
	 * @param str
	 * @throws IOException
	 */
	public void editFile(ArrayList<Bookings> bookingsList, String str) throws IOException {
		
		//this is the old file
		this.bookingsFile = new File(str);
		
		//this is the creation of the new file
		File read = new File("thisfileisnotinthesystem.txt");
		
		//this allows the file to be edited once created.
		FileWriter fw = new FileWriter(read, true);
		
		//this enables data to be written onto the file.
		PrintWriter pw1 = new PrintWriter(fw);
		
		//this code writes the content or the bookingsList arrayList using the toString created in the bookings object.
		for(int i = 0; i < bookingsList.size(); i++) {
			
			pw1.println(bookingsList.get(i).toString3());
		}
		
		pw1.close();
		
		//this code deletes the old file to enable the new file to be renamed the old file name
		bookingsFile.delete();
		
		//this recreates the old file name and passes the name to the new file.
		File replace = new File(str);
		
		//this codes renames it original file name to the old file name.
		read.renameTo(replace);
		
	}
	
	//end of inspired code.
}
	


