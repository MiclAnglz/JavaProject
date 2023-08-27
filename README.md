<strong>Special notes:</strong>

- This program runs completely from the Eclipse console. To start the program follow the next 2 steps.
  
  1) You will first be presented with a welcome menu. Enter "1" to start the program. (see picture below)
  
  <img width="176" alt="image" src="https://user-images.githubusercontent.com/103421610/201460154-578fdce4-118c-4737-a448-48a21aeef90b.png">
  
  2) You will then be prompted to enter a "bookings file" to be processed. Choose a .txt files in the projects folder and enter the file name. (example below)
  
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

Upon execution, the program is designed to populate arrays with data from three primary files: a customer file, a booking file, and a service file. The program also effectively manages files containing null values and diverse data types (integer, float, double) to prevent program crashes resulting from improper processing.

Subsequently, the program empowers users to interact with the arrayed data, presenting it in a meaningful manner through the following functionalities:

- Enabling users to visualize customer bookings.
- Facilitating user-initiated modifications to customer bookings and fee assignments.
- Offering insights into customers' service histories, encompassing service prices, dates, customer IDs, and names.
- Providing a mechanism for users to apply discounts as per customer requests.

The discount mechanism operates as follows:

1. User inputs a value.
2. If the value exceeds 10% of the service cost, the total service cost remains unaffected.
3. If the value is 10% or less, the program accepts, updates, and securely stores the information in the booking text file.

Additional capabilities of the program include:

- Displaying comprehensive details of a service, including its ID, price, and description.
- Enabling users to search for customer information using either surnames or mobile numbers.
- Addressing the presence of multiple customers with the same name in the customer text file, displaying distinguishing information for clarity.
- Empowering users to securely save or discard modifications made to the text file.

In essence, the program seamlessly handles data ingestion, user interaction, and data persistence while maintaining reliability and user-friendly functionality.
 
<strong>Additional Features:</strong>

- Before exiting the program, the program will only give the option to save the information if changes were made to the file. If changes were not made the program will terminate without displaying the save feature.

<strong>Changes made:</strong>
<img width="267" alt="image" src="https://user-images.githubusercontent.com/103421610/201495875-8036f685-2761-4fe9-ac74-38ebf720d409.png">

<strong>No changes made:</strong>
<img width="270" alt="image" src="https://user-images.githubusercontent.com/103421610/201495916-f9195cc0-7965-47f4-ae71-f76c19eb038f.png">


