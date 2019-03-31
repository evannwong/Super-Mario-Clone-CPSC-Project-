import java.util.*;
import java.io.*;

public class SavingsAccount extends BankAccount{

  private double annualInterestRate = 0.05;
  private double minimumBalance;

/**
*  Default constructor that sets the instance variables
*  to the default values, since none are given.
*/
  public SavingsAccount() {
    this.annualInterestRate = 0.05;
  }

/**
*  Constructor that takes a double as an argument, and
*  sets annualInterestRate to equal this value.
*/
  public SavingsAccount(double anIntRate){
    this.annualInterestRate = anIntRate;
  }

/**
*  Constructor that takes in two doubles - the first is
*  used to specify the balance, and the second is to set
*  the annualInterestRate.
*/
  public SavingsAccount(double balance, double anIntRate) {
    super(balance);
    this.annualInterestRate = anIntRate;
  }

/**
*  Constructor that takes in a Customer argument to set
*  the accountHolder, and a double to set the balance.
*/
  public SavingsAccount(Customer accountHolder, double balance) {
    super(accountHolder, balance);
  }

/**
*  Constructor that takes in a Customer argument to set
*  the accountHolder, a double to set the balance, and a
*  double to set the annualInterestRate.
*/
  public SavingsAccount(Customer accountHolder, double balance, double anIntRate) {
    super(accountHolder, balance);
    this.annualInterestRate = anIntRate;
  }

/**
*  Constructor that takes in a BufferedReader argument
*  and throws an IOException. The reader contains up to
*  two lines - the first line sets the annualInterestRate
*  and the second line sets the minimumBalance.
*/
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


/**
*  This method returns the annualInterestRate as a double.
*/
  public double getAnnualInterestRate(){
    return this.annualInterestRate;
  }

/**
*  This method sets the annualInterestRate to equal the double
*  provided as an argument, if this value is between 0.00 and
*  1.00, inclusive.
*/
  public void setAnnualInterestRate(double rate){
    if (rate <= 1.00 && rate >= 0.00){
      this.annualInterestRate = rate;
    }
  }

/**
*  This method sets the minimumBalance to equal the double
*  provided as an argument, if this value is positive.
*/
  public void setMinimumBalance(double min){
    if (min >= 0.0){
      this.minimumBalance = min;
    }
  }

/**
*  This method returns the minimumBalance as a double.
*/
  public double getMinimumBalance(){
    return this.minimumBalance;
  }

/**
*  This method overrides the other withdraw() method of
*  the parent class, and subtracts the amount specified as
*  an argument if the value is greater than zero and the
*  withdrawal would not cause the balance to decrease past
*  the minimumBalance.
*/
  public void withdraw(double amount){
    if (getBalance() - amount >= this.minimumBalance){
      if (amount > 0 && amount <= getBalance()){
        super.withdraw(amount);
      }
    }
  }

/**
*  This method calculates the monthly interest accrued by
*  the account and adds this value to the balance.
*/
  public void depositMonthlyInterest(){
    double fees = (this.annualInterestRate * this.getBalance()) / 12;
    this.deposit(fees);
  }

/**
*  This method calculates the monthly interest accrued by
*  the account and returns this value as a double.
*/
  @Override
  protected double getMonthlyFeesAndInterest(){
    return (this.annualInterestRate * this.getBalance()) / 12;
  }

/**
*  This method creates a PrintWriter and writes two lines,
*  one line being the annualInterestRate and the other being
*  the minimumBalance.
*/
  public void saveToTextFile(String fileName) throws IOException{
    super.saveToTextFile(fileName);
    PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, true));
    writer.println(getAnnualInterestRate());
    writer.println(this.minimumBalance);
    writer.close();
  }
}
