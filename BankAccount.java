import java.util.*;
import java.io.*;
import java.lang.Math;

public abstract class BankAccount{
  /** Instance variables for BankAccount class */
  private double balance;
  private String accountNumber;
  private Customer accountHolder;

  /** Method to transfer money to a different account */
  public void transfer(int a, BankAccount b){
    if (this.getBalance() >= a){
      b.deposit(a);
      this.withdraw(a);
    }
  }

  /** Method of type Customer that returns the account holder */
  public Customer getAccountHolder() throws NullPointerException{
    return this.accountHolder;
  }

  /** Method to set the name of the account holder */
  public void setAccountHolder(Customer account){
    this.accountHolder = account;
  }

  /** Default constructor for the bank account class */
  public BankAccount(){
    Random rand = new Random();
    balance = 0.0;
    accountNumber = String.format("%04d", rand.nextInt(9999) + 1);
  }

  /** Copy constructor for the bank account class */
  public BankAccount(BankAccount b){
    this.balance = b.balance;
    this.accountNumber = b.accountNumber;
    this.accountHolder = b.accountHolder;
  }

  /** Constructor that takes in a double as an argument */
  public BankAccount(double initialAmount){
    Random rand = new Random();
    balance = initialAmount;
    accountNumber = String.format("%04d", rand.nextInt(9999) + 1);
  }

  /** Constructor that takes in a double and a String as an argument */
  public BankAccount(double initialAmount, String givenAccountNumber){
    balance = initialAmount;
    accountNumber = givenAccountNumber;
  }

  /** Constructor that takes in a Customer and a double as an argument */
  public BankAccount(Customer givenHolder, double initialAmount){
    balance = initialAmount;
    this.accountHolder = givenHolder;
  }

  /** Constructor that takes in a character-input stream */
  public BankAccount(BufferedReader reader)
    throws IOException
  {
    String line1 = reader.readLine();
    if ((line1 == null) || (line1.equals("null"))){
      this.balance = 0.0;
    } else{
      line1 = String.valueOf(line1);
      this.balance = Double.parseDouble(line1);
    }
    String line2 = reader.readLine();
    if ((line2 == null) || (line2.equals("null"))){
      this.accountNumber = null;
    } else{
      this.accountNumber = line2;
    }
    try{
      this.accountHolder = new Customer(reader);
    } catch (IOException localIOException){
      setAccountHolder(null);
    }
  }

  /** Method to get the balance */
  public double getBalance(){
    return this.balance;
  }

  /** Method to get the account number */
  public String getAccountNumber(){
    return accountNumber;
  }

  /** Method that returns a string with the information about the bank account */
  public String toString(){
    String string = "(" + this.accountHolder + ") " + this.accountNumber + ": " + this.balance;
    return string;
  }

  /** Method to add money to the balance */
  public void deposit(double amount){
    if (amount > 0){
      balance += amount;
      balance = Math.round(balance * 100);
      balance = balance/100;
    }
  }

  /** Method to subtract money from the balance */
  public void withdraw(double amount){
    if (amount > 0 && amount <= balance){
      balance -= amount;
      balance = Math.round(balance * 100);
      balance = balance/100;
    }
  }

  /** Abstratc method for getting the monthly fees and interest */
  protected abstract double getMonthlyFeesAndInterest();

  /** Method to update the balance from the monthly fees and interest */
  public void monthEndUpdate(){
    double temp = this.getMonthlyFeesAndInterest();
    this.balance += temp;
  }

  /** Method to write out on to a text file */
  public void saveToTextFile(String fileName) throws IOException{
    PrintWriter writer = new PrintWriter(fileName);
    writer.println(this.balance);
    if (this.accountNumber == null || this.accountNumber.equals("null")){
      writer.println();
    } else{
      writer.println(this.accountNumber);
    }
    if (this.accountHolder == null){
      writer.println("null");
    } else{
      accountHolder.save(writer);
    }
    writer.close();
  }
}