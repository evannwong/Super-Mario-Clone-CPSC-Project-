public class ChequingAccount extends BankAccount{
  
  /** Instance variables for the ChequingAccount class */
  private double overdraftFee;
  private double overdraftAmount;
  
  /** Constructor that take in a Customer, and two doubles */
  public ChequingAccount(Customer c, double balance, double overdraftFee){
    super(c, balance);
    if (overdraftFee >= 0){
      this.overdraftFee = overdraftFee;
    } else{
      this.overdraftFee = 1.0;
    }
  }

  /** Method that sets the overdraft fee amount that takes a double as an argument */
  public void setOverdraftFee(double amount){
    if (amount >= 0){
      this.overdraftFee = amount;
    } else{
      return;
    }
  }
  
  /** Method that returns the overdraft fee */
  public double getOverdraftFee(){
    return this.overdraftFee;
  }

  /** Method that sets the overdraft fee amount that takes a double as an argument */
  public void setOverdraftAmount(double amount){
    if (amount >= 0){
      this.overdraftAmount = amount;
    } else{
      return;
    }
  }

  /** Method that returns the overdraft amount */
  public double getOverdraftAmount(){
    return this.overdraftAmount;
  }

  /** Overrideen method that checks to see if the account has sufficient funds */
  @Override
  public boolean sufficientFunds(double amount){
    boolean condition = true;
    if (this.getBalance() - amount <= 0){
      condition = true;
    }
    if (this.getBalance() - amount + this.overdraftAmount < 0){
      condition = false;
    }
    return condition;
  }
  
/** Overrideen method that withdraws from the balance. A double is passed through as an argument */
  @Override
  public void withdraw(double amount){
    if (this.getBalance() - amount < 0){
      if (this.sufficientFunds(amount)){
        super.withdraw(amount + overdraftFee);
      }
    } else{
      super.withdraw(amount);
    }
  }

  /** Overridden method that returns the monthly fees and interest */
  @Override
  public double getMonthlyFeesAndInterest(){
    if (this.getBalance() >= 0){
      return 0;
    } else{
      return (this.getBalance() * 0.2);
    }
  }
}
