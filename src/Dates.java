import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */
public class Dates {
	
	public static Date todayDate = new Date();
	
	/**
	 * @return the todayDate returns todays date
	 */
	public static String getTodaysDate() {
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String todaysDate = "";

		todaysDate = myFormat.format(todayDate);

		return todaysDate;		
	}

	/**
	 * this method validates a users entry to enter a date in a dd/mm/yyyy format. 
	 * 
	 * @param m passes the Menu class a parameter
	 * @return str returns a date in a dd/mm/yyy format
	 */
	public static String requstDate(Menu m) {
		
		boolean error = true;
		String str = "";														//created to store the string address of a users input.
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		str = m.requestStringOption("\nEnter new date: ");
		
		while (error == true) {
			
			try {
				
				Date userEntry = myFormat.parse(str);
				str = myFormat.format(userEntry);

				error = false;
			} 

			catch (ParseException e) {
				
				System.out.println("\n ** Incorrect input ** ");
				System.out.println("\nThe date must be entered as: DD/MM/YYYY");
				System.out.println("\nExample: \n");
				System.out.println("25th July 2021 must be entered as: 25/07/2021");
				
				str = m.requestFile("\nEnter new date: ");
				 
			}
		
		}
		
		return str;
	}
	/**
	 * Parsing a string to an object was inspired by: https://youtu.be/J8NuJAYD_S0
	 * 
	 * this method checks if the date inputed by the user is available.
	 * 
	 * @param b passes the Bookings object		
	 * @param s passes the string input from the user to be validated 
	 * @return the validated string date
	 * @throws ParseException date format exemption
	 */
	public static String dateAvail(ArrayList<Bookings> bookingsList, String s) throws ParseException {
		
		SimpleDateFormat nf = new SimpleDateFormat("dd/MM/yyyy");
		String todaysDate = "";
		Date todayDate = new Date();
		todaysDate = nf.format(todayDate);
		boolean error = false;							//used to flag if the date is accepted or noot
		boolean loop = true;							//created to start the loop and will continue to iterate through the loop until false
		Menu m = new Menu();
		
		while (loop) {
			
			String uDate = s;							//String s is the date passed on from the previous method to be checked for availability
			Date userDate = nf.parse(uDate);
	
			for (int i = 0; i < bookingsList.size(); i++ ) {
				
				String str = bookingsList.get(i).getDate();
				Date aDate = nf.parse(str);
				
				if (userDate.equals(aDate) ) {							//will break out of the loop if the user date equals a date in the bookingsList arrayList
					error = true;	
					break;
				}
				
				if (userDate.equals(todayDate)){						//will break out of the loop if the user date equals todays date
					error = true;
					break;
				}
				
				if (userDate.before(todayDate)) {						//will break out of the look if the user enters a date before todays date	
					error = true;
					break;
				}
				
				else {
					error = false;										//will return false if user enters a valid date.
				}
			}
			
			if(error == false) {
				System.out.println("\nDate accepted!\n");
				loop = false;
			}
			
			//this block of code will get the user to re-enter a date until the user enters a valid date.
			else {
				
				System.out.println("\n ** Date unavailable ** \n");
				System.out.println("The following dates are unavailable: \n");
				
				for (int J = 0 ; J < bookingsList.size(); J ++) {
					
					System.out.println(bookingsList.get(J).getDate());
				}
				
				System.out.println("\n*** Please choose a date that is greater than " + todaysDate + " or that is not on the above list of dates ***"  );
				s = Dates.requstDate(m);
				error = false; 
			
			}
		}
		
		return s;
	}

}
