import java.util.*;
import java.io.*;

public class SavingsAccount extends BankAccount{

  /** Instance variables for the SavingsAccount class */
  private double annualInterestRate = 0.05;
  private double minimumBalance;

/** Default constructor that sets the instance variables to the default values since none are given. */
  public SavingsAccount() {
    this.annualInterestRate = 0.05;
  }

/** Constructor that takes a double as an argument, and sets the instance variable annualInterestRate equal to it. */
  public SavingsAccount(double anIntRate){
    this.annualInterestRate = anIntRate;
  }

  /** Constructor that take in a two doubles */
  public SavingsAccount(double balance, double anIntRate) {
    super(balance);
    this.annualInterestRate = anIntRate;
  }

  /** Constructor that take in a Customer and a double */
  public SavingsAccount(Customer accountHolder, double balance) {
    super(accountHolder, balance);
  }

/** Constructor that takes Customer accountHolder, double balance, and double anIntRate as an argument, and respectively sets them equal to the corresponding instance variable. */
  public SavingsAccount(Customer accountHolder, double balance, double anIntRate) {
    super(accountHolder, balance);
    this.annualInterestRate = anIntRate;
  }

  /** Constructor that take in a character-input stream */
  public SavingsAccount(BufferedReader reader) throws IOException{
    super(reader);
    String line1 = reader.readLine();
    if ((line1 == null) || (line1.equals("null"))){
      this.annualInterestRate = 0.0;
    } else{
      this.annualInterestRate = Double.parseDouble(line1);
    }
    String line2 = reader.readLine();
    if ((line2 == null) || (line2.equals("null"))){
      this.minimumBalance = 0.0;
    } else{
      this.minimumBalance = Double.parseDouble(line2);
    }
  }


/** Returns the annualInterstRate. */
  public double getAnnualInterestRate(){
    return this.annualInterestRate;
  }

/** Sets the annualInterestRate as the rate given, if the rate is greater than or equal to 0 while less than or equal to 1. */
  public void setAnnualInterestRate(double rate){
    if (rate <= 1.00 && rate >= 0.00){
      this.annualInterestRate = rate;
    }
  }

/** Sets the minimumBalance as the min given if parameter min is greater than or equal to 0. */
  public void setMinimumBalance(double min){
    if (min >= 0.0){
      this.minimumBalance = min;
    }
  }

  /** Method that returns the minimum balance of the account */
  public double getMinimumBalance(){
    return this.minimumBalance;
  }

/** Overrides the withdraw() method from parents class and only withdraws if the balance after said withdrawal is greater or equal to the minimum balance. */
  public void withdraw(double amount){
    if (getBalance() - amount >= this.minimumBalance){
      if (amount > 0 && amount <= getBalance()){
        super.withdraw(amount);
      }
    }
  }

  /** Method that deposits the monthly interest of the account */
  public void depositMonthlyInterest(){
    double fees = (this.annualInterestRate * this.getBalance()) / 12;
    this.deposit(fees);
  }

  /** Overridden method that get the monthly fees and interest */
  @Override
  protected double getMonthlyFeesAndInterest(){
    return (this.annualInterestRate * this.getBalance()) / 12;
  }

  /** Method that saves a text file with the annual interest rate and minimum balance */
  public void saveToTextFile(String fileName) throws IOException{
    super.saveToTextFile(fileName);
    PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true));
    writer.println(getAnnualInterestRate());
    writer.println(this.minimumBalance);
    writer.close();
  }
}
