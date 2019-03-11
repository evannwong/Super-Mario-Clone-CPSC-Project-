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
        this.accountHolder = accHold;
    }

    public void transfer(int b, BankAccount newacc){
        if (sufficientFunds(b)) {
            this.withdraw(b);
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
        if (sufficientFunds(amount2) && amount2 >= 0) {
            this.balance -= amount2;
        }
    }

    public String toString(){
        return "(" + accountHolder.getName() + " " + accountHolder.getID() + ")" + " " + this.accountNumber + ": " + this.balance;
    }

    public boolean sufficientFunds(double funds){
        if (funds <= this.balance){
            return true;
        } else {
            return false;
        }
    }

    BankAccount() {
        this.balance = 0.0;
        this.accountNumber = "0001";
        this.accountHolder = null;
    }

    BankAccount(double bal) {
        this.balance = bal;
        this.accountNumber = "0001";
        this.accountHolder = null;
    }

    BankAccount(double bal, String acc) {
        if (bal >= 0){
            this.balance = bal;
          } else{
            this.balance = 0.0;
          }
        this.accountNumber = acc;
        this.accountHolder = null;
        }

    BankAccount(Customer cust, double bal){
        if (bal >= 0){
            this.balance = bal;
        } else{
            this.balance = 0.0;
        }
        this.accountNumber = "0001";
        this.accountHolder = cust;
    }

    BankAccount(BankAccount bankAcc) {
       this.accountNumber = bankAcc.getAccountNumber();
       this.accountHolder = bankAcc.getAccountHolder();
       this.balance = bankAcc.getBalance();
    }
}
