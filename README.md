# overconfident-giants-5053
Administrator

Administrator which allows an administrator to manage a list of consumers and their bills. The administrator can log in, register new consumers, view and delete consumers, view bills, and view paid and pending bills.

The Administrator class has several instance variables: username, password, and consumers. The username and password variables are the login credentials for the administrator. The consumers variable is a list of Consumer objects.

The Administrator class has several methods:

login(): Allows the administrator to log in. The method prompts the user to enter a username and password, and if they match the stored credentials, the method returns true indicating a successful login. Otherwise, the method returns false.

registerConsumer(): Allows the administrator to register a new consumer. The method prompts the user to enter the consumer's first name, last name, address, mobile number, email, username, and password. The method then creates a new Consumer object with these attributes and adds it to the consumers list.

viewAllConsumers(): Allows the administrator to view all consumers in the consumers list. The method iterates through the list and prints the toString() representation of each Consumer object.

viewConsumerBill(): Allows the administrator to view the bills for a specific consumer. The method prompts the user to enter a username, and then searches the consumers list for a Consumer object with that username. If found, the method prints the toString() representation of each Bill object associated with the Consumer.

viewAllBills(): Allows the administrator to view all bills for all consumers in the consumers list. The method iterates through the consumers list, and for each Consumer object with non-empty bills list, prints the toString() representation of each Bill object in the list.

viewPaidAndPendingBills(): Allows the administrator to view all paid and pending bills for all consumers in the consumers list. The method iterates through the consumers list, and for each Consumer object with non-empty bills list, adds the Bill object to either the paidBills or pendingBills list depending on its status. The method then prints the toString() representation of each Bill object in each list.

deleteConsumer(): Allows the administrator to delete a specific consumer. The method prompts the user to enter a username, and then searches the consumers list for a Consumer object with that username. If found, the method removes the Consumer object from the list.

toString(): Returns a string representation of the Administrator object, consisting of the administrator's username.

getConsumerByUsername(String username): Returns a Consumer object with the given username, or null if no such object is found.

The Administrator class also has a main() method which initializes an Administrator object, logs in the administrator, and presents a menu of options to the administrator. Depending on the user's choice, the method calls one of the instance methods to perform the requested action.


"Bill"

Bill that represents a bill generated for a consumer. The class has the following instance variables: id (a unique identifier for the bill), consumerUsername (the username of the consumer for whom the bill is generated), dateGenerated (the date on which the bill is generated), amount (the total amount due for the bill), adjustment (any adjustments made to the bill), amountPaid (the amount paid by the consumer towards the bill), datePaid (the date on which the consumer paid the bill), and status (the current status of the bill, which can be PENDING, PAID, or OVERDUE).

The class has a constructor that takes the consumerUsername, amount, and adjustment as input parameters, and initializes the instance variables accordingly. The class also provides several getter and setter methods to access and modify the instance variables.

The class overrides the toString() method to provide a formatted string representation of the bill. The formatted string includes the bill ID, consumer username, date generated, amount, adjustment, amount paid, date paid, and status. The date fields


Bill Status

BillStatus with three possible values: PENDING, PAID, and DISMISSED. This enum is likely used to represent the status of a bill object in a billing system.

Consumer

Consumer class is part of an Electricity Bill Payment System. The class contains properties and methods that allow a consumer to sign up, log in, view transaction history, and pay bills.

The Consumer class has the following properties:

firstName (String): The first name of the consumer.
lastName (String): The last name of the consumer.
address (String): The address of the consumer.
mobileNumber (String): The mobile number of the consumer.
email (String): The email of the consumer.
username (String): The username of the consumer.
password (String): The password of the consumer.
bills (List of Consumer): A list of bills for the consumer.
isActive (boolean): A flag that indicates whether the consumer is active or not.
The Consumer class has the following methods:

Consumer(String, String, String, String, String, String, String): A constructor that initializes the properties of the consumer object with the specified values.
Consumer(): A default constructor that initializes the bills property with an empty list and sets isActive to true.
signup(): A method that allows a consumer to sign up by entering their personal information and a username and password. The method checks if the username is available and if not, prompts the user to enter a different username.
static Consumer login(): A static method that allows a consumer to log in by entering their username and password. The method checks if the username and password are valid and returns the corresponding consumer object if successful, otherwise, it returns null.
private boolean isValidUsername(String): A private method that checks if the username is valid (i.e., not already taken).
public String getFullName(): A method that returns the full name of the consumer.
public String getUsername(): A method that returns the username of the consumer.
public String getPassword(): A method that returns the password of the consumer.
public void addBill(Consumer): A method that adds a bill to the bills list.
public void payBill(): A method that allows a consumer to pay a bill by entering the bill ID and the amount paid. The method calculates the total amount due, including tax, and returns the change if the amount paid is sufficient. Otherwise, it prompts the user to pay the full amount.
public void viewTransactionHistory(): A method that displays the transaction history of the consumer by printing out each bill object in the bills list.
public String toString(): A method that returns a string representation of the consumer object. It includes the full name, address, mobile number, email, and username of the consumer.
private boolean isActive(): A private method that returns the value of the isActive flag.
private Object getId(): A private method that returns the ID of a bill object.
private double getAmount(): A private method that returns the amount due for a bill object.
private void setStatus(BillStatus): A private method that sets the status of a bill object to either "PAID" or "PENDING".
private void setAmountPaid(double): A private method that sets the amount paid for a bill object.
private void setDatePaid(LocalDate): A private method that sets the date when a bill object was paid.

Electricity Bill Payment System

Electricity Bill Payment System. The program uses serialization to store and retrieve data. The system has two types of users: Administrator and Consumer.

The Administrator can register new consumers, view all consumers, view consumer bills, view all bills, view paid and pending bills, and delete consumers.

The Consumer can sign up, log in, pay bills, and view transaction history.

The program reads user input using a Scanner object, and it displays output to the console. The program uses try-catch blocks to handle exceptions.