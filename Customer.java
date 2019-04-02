import java.io.*;

public class Customer{
	
/** Instance variables for the Customer class */	
  String name;
  int customerID;

/** Default constructor for the Customer class */
  public Customer(){
    String name = "Customer";
    int customerID = 0;
  }

/** Copy constructor for the Customer class */
  public Customer(Customer c){
    this.name = c.name;
    this.customerID = c.customerID;
  }

/** Method that sets the name of the Customer */
  public void setName(String GivenName){
    this.name = GivenName;
  }

/** Constructor that takes in a String of a name, and an integer for the ID */
  public Customer(String GivenName, int ID){
    this.name = GivenName;
    this.customerID = ID;
  }

/** Construcor that take in a character-input stream */
  public Customer(BufferedReader reader) throws IOException {
		String line1 = reader.readLine();
		if ((line1 == null) || line1.equals("null")){
		  throw new IOException("Customer is null in file");
		} else{
		  this.name = line1;
		  String line2 = reader.readLine();
		  if ((line2 == null) || (line2 == "null")) {
		    throw new IOException("No customer ID found in file");
		  } else{
		    this.customerID = Integer.parseInt(line2);
		  }
		}
  }

/** Method to get the name of the customer */
  public String getName(){
    return this.name;
  }
	
/** Method to get the ID of the customer */
  public int getID(){
    return this.customerID;
  }
	
/** Method to take the variables and return them as a constructed string */
  public String toString(){
    String stringVar = this.name + " " + this.customerID;
    return stringVar;
  }

/** Method that saves a file with the variables and their information */
  public void save(PrintWriter write){
    try{
      write.println(this.name);
      write.println(this.customerID);
    } catch(Exception e){
      System.out.println("No customer ID found in file");
    }
  }
}
