package ATMPackage;

public class ATM {
    private double balance;
    
    public void deposit(double money) {
        balance += money;
    }
    
    public void withdraw(double money) {
        balance -= money;
    }
    
    public double getBalance() {
        return balance;
    }
}