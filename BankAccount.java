import java.util.*;
import java.io.*;
import java.lang.Math;

public abstract class BankAccount{
  private double balance;
  private String accountNumber;
  private Customer accountHolder;

  public void transfer(int a, BankAccount b){
    if (this.getBalance() >= a){
      b.deposit(a);
      this.withdraw(a);
    }
  }

  public Customer getAccountHolder() throws NullPointerException{
    return this.accountHolder;
  }

  public void setAccountHolder(Customer account){
    this.accountHolder = account;
  }

  public BankAccount(){
    Random rand = new Random();
    balance = 0.0;
    accountNumber = String.format("%04d", rand.nextInt(9999) + 1);
  }

  public BankAccount(BankAccount b){
    this.balance = b.balance;
    this.accountNumber = b.accountNumber;
    this.accountHolder = b.accountHolder;
  }

  public BankAccount(double initialAmount){
    Random rand = new Random();
    balance = initialAmount;
    accountNumber = String.format("%04d", rand.nextInt(9999) + 1);
  }

  public BankAccount(double initialAmount, String givenAccountNumber){
    balance = initialAmount;
    accountNumber = givenAccountNumber;
  }

  public BankAccount(Customer givenHolder, double initialAmount){
    balance = initialAmount;
    this.accountHolder = givenHolder;
  }

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

  public double getBalance(){
    return this.balance;
  }

  public String getAccountNumber(){
    return accountNumber;
  }

  public String toString(){
    String string = "(" + this.accountHolder + ") " + this.accountNumber + ": " + this.balance;
    return string;
  }

  public void deposit(double amount){
    if (amount > 0){
      balance += amount;
      balance = Math.round(balance * 100);
      balance = balance/100;
    }
  }

  public void withdraw(double amount){
    if (amount > 0 && amount <= balance){
      balance -= amount;
      balance = Math.round(balance * 100);
      balance = balance/100;
    }
  }

  protected abstract double getMonthlyFeesAndInterest();

  public void monthEndUpdate(){
    double temp = this.getMonthlyFeesAndInterest();
    this.balance += temp;
  }

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
