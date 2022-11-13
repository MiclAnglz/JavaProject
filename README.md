<strong>Special notes:</strong>

- This program runs completely from the Eclipse console. To start the program follow the next 2 steps.
  
  1) You will first be presented with a welcome menu. Enter "1" to start the program. (see picture below)
  
  <img width="176" alt="image" src="https://user-images.githubusercontent.com/103421610/201460154-578fdce4-118c-4737-a448-48a21aeef90b.png">
  
  2) You will then be prompted to enter a "bookings file" to be processed. Choose a .txt files in the projects folder and enter the file name. (as below)
  
  <img width="113" alt="image" src="https://user-images.githubusercontent.com/103421610/201460356-a8f6ef3b-622a-4d95-b8b7-599f1203df50.png">
  
  <img width="178" alt="image" src="https://user-images.githubusercontent.com/103421610/201460423-035506c2-6c5a-4f27-995c-fa6ce871a5eb.png">

- When making a booking you will notice that the program prompts you to enter a least 1 service code. This was part of the project brief. However, this can be canceled before exiting the program (see additional features below).

<img width="444" alt="image" src="https://user-images.githubusercontent.com/103421610/201513943-db371ad8-2ab9-44db-bb68-183e2574ab7a.png">

- The surname for a customer can be found in the customer.txt file after the customer_ID
  
  - <strong>column order for the customer.txt-</strong> customerID, surname, firstname, mobile, adddress, suburb, postcode 

- A more detailed description of the project tasks can be found in the "ProjectBrief" folder. 

# Java Project 
<h4>(My First Major Coding Project)</h4>
Programming Techniques Major Project - Java

Spring Semester
Programming Techniques 

<strong>Task: </strong>Create a system application for a ficticious air conditioning business.
The project requirements were to design an object
orientated Java program to
assist the business in keeping records of repair, service and
installation.

Upon execution, the program has to read data into arrays from 3 main files - a
customer file, a booking file and a service file. The program also had to handle
files with null values and different data types (int, float, doubles), as they crash the program if not processed correctly.

The program then had to give the user the ability to interact with the data in
the arrays and display the items in a meaningful way i.e.

• Allow the user to display customer booking

• Allow the user to change customer bookings and set fees

• Allow the user to display the customers service history, price of the service,
date, customer id and name

• Allow the user to apply discounts based on the customer's request. 
   
   <strong>How?</strong>
   
  - Accept a value from the customer. If that value is
greater than 10% of the service cost, the total amount of the service is to
remain. If the value is 10% or less, then the program is to accept, update and save the information 
into the booking text file.

• Allow the user to display full details of a service (service id , price and
description)

• Allow the user to search customer information by surname or mobile
number. 

<strong>note: </strong>Many customers on the customer text file also had the same name.
The program had to present all customers with the same
name on the file and display the information that would differentiate one
from the other

• Allow the user to save or cancel changes made to text file.
 
<strong>Additional Features:</strong>

- Before exiting the program, the program will only ask give the option to save the information if changes were made to the file, if changes were not made it will terminate without displaying the save feature.

<strong>Changes made:</strong>
<img width="267" alt="image" src="https://user-images.githubusercontent.com/103421610/201495875-8036f685-2761-4fe9-ac74-38ebf720d409.png">

<strong>No changes made:</strong>
<img width="270" alt="image" src="https://user-images.githubusercontent.com/103421610/201495916-f9195cc0-7965-47f4-ae71-f76c19eb038f.png">


