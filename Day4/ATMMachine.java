import ATMPackage.ATM;
import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM Atm = new ATM();
        
        boolean exit = false;
        while(!exit) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            
            int option = sc.nextInt();
            
            switch(option) {
                case 1:
                    {
                        System.out.print("Enter the amount to deposit : ");
                        double money = sc.nextDouble();
                        Atm.deposit(money);
                        System.out.println("Current Balance : " + Atm.getBalance());
                    }
                    break;
                case 2:
                    {
                        System.out.print("Enter the amount to withdraw : ");
                        double money = sc.nextDouble();
                        Atm.withdraw(money);
                        System.out.println("Current Balance : " + Atm.getBalance());
                    }
                    break;
                case 3:
                    {
                        System.out.println("Your Balance : " + Atm.getBalance());
                    }
                    break;
                case 4:
                    {
                        System.out.println("Thanks for Visiting");
                        exit = true;
                    }
                    break;
                default :
                    System.out.println("Enter a valid option");
            }
        } 
    }
}