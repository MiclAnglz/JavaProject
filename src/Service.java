import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;

 /**
 * Student ID: 20455936
 * Name: Michael Angeles
 * Campus:  Parramatta South
 * Tutor Name: Rhys Tague  
 * Class Day: Monday
 * Class Time: 3pm
 */

public class Service  {
	
	private int serviceCode;												//Stores the services code read Services.txt
	private String serviceName;												//Stores the services name read Services.txt
	private String serviceDescription;										//Stores the services description read Services.txt
	private float Serviceprice;												//Stores the services price read Services.txt
	private ArrayList<Integer> joinArray;									//Stores the services code read Services.txt
	private ArrayList<Integer> positionArray;								//Stores the positions of multiple elements from an arryList
	
	//default constructor
	public Service () {}
	
	/**
	 ** This constructor was for the file processing process to store information as a reference object for an arrayList that was created from 
	 * Services.txt 
	 * 
	 * 
	 * @param serviceCode passes the service codes read from Services.txt
	 * @param serviceName passes the service Name read from Services.txt
	 * @param serviceDescription passes the service Description codes read from Services.txt
	 * @param Serviceprice passes the Description codes read from Services.txt
	 * @param joinArray passes just the service codes that was read from Services.txt
	 */
	public Service (int serviceCode, String serviceName, String serviceDescription, float Serviceprice, ArrayList<Integer> joinArray) {
		
		this.serviceCode = serviceCode;									
		this.serviceName = serviceName;									
		this.serviceDescription = serviceDescription;					
		this.Serviceprice = Serviceprice;								
		this.joinArray = joinArray;								
		
	}
	
	/**
	 * This constructor was for the file processing process to store information as a reference object for an arrayList that was created from 
	 * Services.txt 
	 * 
	 * @param serviceCode passes the service codes read from Services.txt
	 * @param serviceName passes the service Name read from Services.txt
	 * @param serviceDescription passes the service Description codes read from Services.txt
	 * @param joinArray passes just the service codes that was read from Services.txt
	 */
	public Service (int serviceCode, String serviceName, String serviceDescription, ArrayList<Integer> joinArray) {
		
		this.serviceCode = serviceCode;									
		this.serviceName = serviceName;									
		this.serviceDescription = serviceDescription;					
		this.joinArray = joinArray;										
		
	}
	
	
	/**
	 * Constructor used for an object reference for an arrayList used in the main program
	 * 
	 * @param positionArray pass the arraylist inputed from the  main program
	 */
	Service (ArrayList<Integer> positionArray){
		
		this.setPositionArray(positionArray);
	}
	

	/**
	 * 
	 * @return passes the position of an element from the arrayList.
	 */
	public ArrayList<Integer> getPositionArray() {
		return positionArray;
	}
	
	/**
	 * 
	 * @param positionArray set the position of an element from the arrayList.
	 */
	public void setPositionArray(ArrayList<Integer> positionArray) {
		this.positionArray = positionArray;
	}
	

	/**
	 * Stores the services codes just the service codes from services.txt
	 * 
	 * @return the serviceCodesArray passes the contents of the array list in the main program. 
	 */
	public ArrayList<Integer> getJoinArray() {
		return joinArray;
	}

	/**
	 * used to store the service when processing the services.txt file 
	 * 
	 * @return the serviceCode returns the content of the arrayList for the main program. 
	 */
	public int getServiceCode() {
		return this.serviceCode;
	}

	/**
	 *  stores the service names from the services.txt file.
	 * 
	 * @return the serviceName returns the service name(s) saved from the services.txt file.
	 */
	public String getServiceName() {
		return this.serviceName;
	}

	/**
	 * Stores the service description from the services.txt file.
	 * 
	 * @return the serviceDescription returns the service description(s) saved from the services.txt file.
	 */
	public String getServiceDescription() {
		return this.serviceDescription;
	}

	/**
	 *  Stores the service price from the services.txt file.
	 * 
	 * @return the service price returns the service price(s) saved from the services.txt file.
	 */
	public Float getServicePrice() {
		return this.Serviceprice;
	}
	
	//prints out the  serviceCode, serviceName, serviceDescription used to create a table in the main program
	public String toString() {
		
		String str = String.format("%-20d\t%-40s\t\t%-80s", this.serviceCode, this.serviceName, this.serviceDescription);
		
		return str;
	}
		
}
