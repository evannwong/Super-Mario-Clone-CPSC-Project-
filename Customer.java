public class Customer {

    private String name;
    private int customerID;

    public void setName(String nam){
        this.name = nam;
    }

    public String getName(){
        return this.name;
    }

    public void setID(int custID){
        this.customerID = custID;
    }

    public int getID(){
        return this.customerID;
    }

    public String toString(){
        return this.name + " " + this.customerID;
    }

    Customer(){
        this.customerID = 0;
        this.name = "";
    }

    Customer(String nam){
        this.customerID = 0;
        this.name = nam;
    }

    Customer(String nam, int ID){
        this.customerID = ID;
        this.name = nam;
    }

    Customer(Customer custInfo){
        this.name = custInfo.getName();
        this.customerID = custInfo.getID();
    }
}