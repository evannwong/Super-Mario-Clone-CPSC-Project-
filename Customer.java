import java.io.*;

public class Customer{
  String name;
  int customerID;

/**
*  Constructor that takes no arguments and sets the
*  instance variables to default values.
*/
  public Customer(){
    String name = "Customer";
    int customerID = 0;
  }

/**
*  Constructor that takes a Customer as an argument and
*  sets the instance variables to equal those provided by
*  the argument Customer.
*/
  public Customer(Customer c){
    this.name = c.name;
    this.customerID = c.customerID;
  }

/**
*  This method takes a String as an argument and sets the
*  name as the argument.
*/
  public void setName(String GivenName){
    this.name = GivenName;
  }

/**
*  Constructor that takes a String argument to set the
*  name and an int argument to set the customerID.
*/
  public Customer(String GivenName, int ID){
    this.name = GivenName;
    this.customerID = ID;
  }

/**
*  Constructor that takes a BufferedReader as an argument
*  and throws an IOException. The first line that is read
*  specifies the name instance variable and the second line
*  specifies the customerID. If a line is null, then an
*  IOException is thrown.
*/
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

/**
*  This method returns the name as a String.
*/
  public String getName(){
    return this.name;
  }

/**
*  This method returns the customerID as a String.
*/
  public int getID(){
    return this.customerID;
  }

/**
*  This method returns the name and customerID as a
*  String in the format: "name customerID".
*/
  public String toString(){
    String stringVar = this.name + " " + this.customerID;
    return stringVar;
  }

/**
*  This method saves the name and customerID as lines
*  of a PrintWriter file. A general Exception is thrown
*  and caught if there is no customerID.
*/
  public void save(PrintWriter write){
    try{
      write.println(this.name);
      write.println(this.customerID);
    } catch(Exception e){
      System.out.println("No customer ID found in file");
    }
  }
}
