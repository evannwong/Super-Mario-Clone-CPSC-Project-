public class ChequingAccount extends BankAccount{
  private double overdraftFee;
  private double overdraftAmount;

  public ChequingAccount(Customer c, double balance, double overdraftFee){
    super(c, balance);
    if (overdraftFee >= 0){
      this.overdraftFee = overdraftFee;
    } else{
      this.overdraftFee = 1.0;
    }
  }

  public void setOverdraftFee(double amount){
    if (amount >= 0){
      this.overdraftFee = amount;
    } else{
      return;
    }
  }

  public double getOverdraftFee(){
    return this.overdraftFee;
  }

  public void setOverdraftAmount(double amount){
    if (amount >= 0){
      this.overdraftAmount = amount;
    } else{
      return;
    }
  }

  public double getOverdraftAmount(){
    return this.overdraftAmount;
  }

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

  @Override
  public double getMonthlyFeesAndInterest(){
    if (this.getBalance() >= 0){
      return 0;
    } else{
      return (this.getBalance() * 0.2);
    }
  }
}
