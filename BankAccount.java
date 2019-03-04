import java.util.Random;

public class BankAccount{
  double balance;
  String accountNumber;
  Customer accountHolder = new Customer();
  boolean canWithdraw;

  public void transfer(int a, BankAccount b){
    if (this.getBalance() >= a){
      b.deposit(a);
      this.withdraw(a);
    }
  }

  public Customer getAccountHolder(){
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
    }
  }

  public void withdraw(double amount){
    if (amount > 0 && amount <= balance){
      balance -= amount;
    }
  }
}
