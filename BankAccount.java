public abstract class BankAccount {
    
    private double balance;
    private Customer accountHolder;
    private String accountNumber;

    protected abstract double getMonthlyFeesAndInterest();
    Customer c = new Customer();

    public void setBalance(double bal){
        this.balance = bal;
    }

    public void monthEndUpdate(){
        this.setBalance(this.getBalance() + this.getMonthlyFeesAndInterest());
    }

    public double getBalance() {
        return this.balance;
    }

    public Customer getAccountHolder(){
        return this.accountHolder;
    }

    public void setAccountHolder(Customer accHold){
        this.c = accHold;
    }

    public void transfer(int b, BankAccount newacc){
        if (sufficientFunds(b)) {
            this.balance -= b;
            newacc.deposit(b);
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit(double amount1) {
        if (amount1 >= 0) {
        this.balance += amount1;
        }
    }

    public void withdraw(double amount2) {
        if (sufficientFunds(amount2)) {
            this.balance -= amount2;
        }
    }

    public String toString(){
        return "(" + c.getName() + " " + c.getID() + ")" + " " + this.accountNumber + ": " + this.balance;
    }

    public boolean sufficientFunds(double funds){
        if (funds >= balance){
            return true;
        } else {
            return false;
        }
    }

    BankAccount() {
        this.balance = 0.0;
        this.accountNumber = "0001";
        this.c = null;
    }

    BankAccount(double bal) {
        this.balance = bal;
        this.accountNumber = "0001";
        this.c = null;
    }

    BankAccount(double bal, String acc) {
        this.balance = bal;
        this.accountNumber = acc;
        this.c = null;
        }
    
    BankAccount(Customer cust, double bal){
        this.balance = bal;
        this.accountNumber = "0001";
        this.c = cust;
    }

    BankAccount(BankAccount bankAcc) {
       this.accountNumber = bankAcc.getAccountNumber();
       this.c = bankAcc.getAccountHolder();
       this.balance = bankAcc.getBalance();
    }
}