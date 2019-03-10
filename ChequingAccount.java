public class ChequingAccount extends BankAccount{
    
    private double overdraftFee;
    private double overdraftAmount;

    @Override
    protected double getMonthlyFeesAndInterest() {
        if (getBalance() >= 0){
            return 0.0;
        } else {
            return getBalance() * 0.2;
        }
    }

    @Override
    public boolean sufficientFunds(double funds) {
        return super.sufficientFunds(funds);
    }

    @Override
    public void withdraw(double amount2) {
        if (getBalance() + overdraftAmount - amount2 >= 0){
            super.withdraw(amount2 + overdraftFee);
        }
    }

    public double getOverdraftFee(){
        return this.overdraftFee;
    }

    public void setOverdraftFee(double fee){
        if (fee >= 0){
            this.overdraftFee = fee;
        }
    }

    public double getOverdraftAmount(){
        return this.overdraftAmount;
    }

    public void setOverdraftAmount(double amount){
        if (amount >= 0){
            this.overdraftAmount = amount;
        }
    }

    public ChequingAccount(Customer accHold, double bal, double overFee){
        super(accHold, bal);
        this.overdraftFee = overFee;
        this. overdraftAmount = 0.0;
    }


}