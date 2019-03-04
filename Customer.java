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
}
