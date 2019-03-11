public class SavingsAccount extends BankAccount{

    private double annualInterestRate = 0.05;
    private double minimumBalance;


    @Override
    public double getMonthlyFeesAndInterest(){
        return ((this.getBalance() * this.annualInterestRate) / 12);
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public double getMinimumBalance(){
        return this.minimumBalance;
    }

    public void setAnnualInterestRate(double intRate){
        if (intRate >= 0.0 && intRate <= 1){
        this.annualInterestRate = intRate;
      } else{
        this.annualInterestRate = 0.05;
      }
    }

    public void setMinimumBalance(double minBal){
        this.minimumBalance = minBal;
    }

    public void withdraw(double amount2) {
        if (amount2 <= getBalance() && 0 <= amount2 && (getBalance() - amount2) >= this.minimumBalance) {
            super.withdraw(amount2);
        }
    }

    public SavingsAccount(){
        super();
        this.annualInterestRate = 0.05;
    }

    public SavingsAccount(double annualInterestRate){
      super();
      if (annualInterestRate > 0){
        this.annualInterestRate = annualInterestRate;
      } else{
        this.annualInterestRate = 0.05;
      }
    }

    public SavingsAccount(double bal, double annRate){
        super(bal);
        if (annualInterestRate > 0){
          this.annualInterestRate = annRate;
        } else{
          this.annualInterestRate = 0.05;
        }
    }

    public SavingsAccount(Customer c, double bal){
        super(c, bal);
    }

    public SavingsAccount(Customer accountHolder, double balance, double annualInterestRate){
        super(accountHolder, balance);
        if (annualInterestRate > 0){
          this.annualInterestRate = annualInterestRate;
        } else{
          this.annualInterestRate = 0.05;
        }
    }
}
