abstract class Bank {
    public abstract int getBalance();
    
    public abstract void deposit(int money);
}

class BankA extends Bank {
    private int balance;
    
    public int getBalance() {
        return balance;
    }
    
    public void deposit(int money) {
        balance += money;
    }
}

class BankB extends BankA {

}

class BankC extends BankA {

}

public class AbstractBank {
    public static void main(String[] args) {
    BankA bankA = new BankA();
    BankB bankB = new BankB();
    BankC bankC = new BankC();
    
    bankA.deposit(100);
    bankB.deposit(150);
    bankC.deposit(200);
    System.out.println("BankA balance : " + bankA.getBalance());
    System.out.println("BankA balance : " + bankB.getBalance());
    System.out.println("BankA balance : " + bankC.getBalance());
}
}
