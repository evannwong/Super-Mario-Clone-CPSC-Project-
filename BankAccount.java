/*

Create a class called BankAccount that has two instance variables: balance of type double and accountNumber of type String.

Accessor (getter) Methods:
getBalance() which returns the value of the instance variable balance.
getAccountNumber() which returns the value in the instance variable accountNumber.
toString() which returns the information in the instance variables in the following format: <account number>: <balance>

Mutator (setter) Methods:
deposit and withdraw. Each take a double as an argument and don't return anything.

Constructors:
Default (no arguments)
One that takes a start balance.
One that takes a start balance and account number.

*/
public class BankAccount {
    
    private double balance;
    private String accountNumber;

    public double getBalance() {
        return this.balance;
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
        if (amount2 <= balance && 0 <= amount2) {
            this.balance -= amount2;
        }
    }

    public String toString(){
        return this.accountNumber + ": " + this.balance; }

    BankAccount() {
        this.balance = 0.0;
        this.accountNumber = "0001";
    }

    BankAccount(double balance) {
        this.balance = balance;
        this.accountNumber = "0001";
    }

    BankAccount(double bal, String acc) {
        balance = bal;
        accountNumber = acc;
        }
}