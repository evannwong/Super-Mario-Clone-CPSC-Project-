import java.io.*;

public class Customer{
  String name;
  int customerID;


  public Customer(){
    String name = "Customer";
    int customerID = 0;
  }

  public Customer(Customer c){
    this.name = c.name;
    this.customerID = c.customerID;
  }

  public void setName(String GivenName){
    this.name = GivenName;
  }

  public Customer(String GivenName, int ID){
    this.name = GivenName;
    this.customerID = ID;
  }

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

  public String getName(){
    return this.name;
  }

  public int getID(){
    return this.customerID;
  }

  public String toString(){
    String stringVar = this.name + " " + this.customerID;
    return stringVar;
  }

  public void save(PrintWriter write){
    try{
      write.println(this.name);
      write.println(this.customerID);
    } catch(Exception e){
      System.out.println("No customer ID found in file");
    }
  }
}
