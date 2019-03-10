public class SavingsAccount extends BankAccount{
    
    private double annualInterestRate;
    private double minimumBalance;
    private double balance = getBalance();

    @Override
    public double getMonthlyFeesAndInterest(){
        return getBalance() * (this.annualInterestRate / 12);
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
        }
    }

    public void setMinimumBalance(double minBal){
        this.minimumBalance = minBal;
    }
    
    public void withdraw(double amount2) {
        if (amount2 <= getBalance() && 0 <= amount2 && (getBalance() - amount2) >= minimumBalance) {
            this.balance -= amount2;
        }
    }

    public SavingsAccount(){
        super();
        this.annualInterestRate = 0.05;
    }

    public SavingsAccount(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public SavingsAccount(double minBal, double annRate){
        this.minimumBalance = minBal;
        this.annualInterestRate =annRate;
    }

    public SavingsAccount(Customer c, double bal){
        super(c, bal);
        this.balance = bal;
    }

    public SavingsAccount(Customer accountHolder, double balance, double annualInterestRate){
        super(accountHolder, balance);
        this.annualInterestRate = annualInterestRate;
        this.balance = balance;
    }
}