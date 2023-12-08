import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class Transaction {
    static int id;
    int t_id;
    String remark;
    String type;
    int amount;
    
    Transaction(String remark,String type,int amount) {
        this.t_id = ++id;
        this.remark = remark;
        this.type = type;
        this.amount = amount;
    }
    
    public void getTransaction() {
        System.out.println(this.t_id + " " + this.remark + " " + this.type + " " + this.amount);
    }
}

class Customer {
    static int n = 101;
    int ac_no;
    String name;
    int pin;
    int balance;
    ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Customer(int ac_no,String name,int pin,int balance) {
        this.ac_no = n++;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }    
    
    
    public void showCustomer() {
        System.out.println(this.ac_no + " " + this.name + " " + this.pin + " " + this.balance);
    }
    
}


class ATM { 
    static Scanner sc = new Scanner(System.in);
    static int total_amount = 0;
    static HashMap<Integer,Integer> denomination = new HashMap<>();
    static HashMap<Integer,Customer> customers = new HashMap<>();
    
    public static void loadCash() {
        System.out.print("Enter 1000 denomination : ");
        int d1 = sc.nextInt();
        denomination.put(1000,d1);
        total_amount += d1*1000;
        System.out.print("Enter 500 denomination : ");
        int d2 = sc.nextInt();
        denomination.put(500,d2);
        total_amount += d2*500;
        System.out.print("Enter 100 denomination : ");
        int d3 = sc.nextInt();
        denomination.put(100,d3);
        total_amount += d3 * 100;
        System.out.println("total amount in ATM : " + total_amount);
    }
    
    public static void showCustomers() {
          System.out.println("Acc No    Account Holder    PinNumber     Account Balance");
          for(int ac_no : customers.keySet()) {
              customers.get(ac_no).showCustomer();
          }
    }
    
    public static void menuPage() {
        System.out.print("Enter ac_no : ");
        int ac_no = sc.nextInt();
        System.out.print("Enter pin : ");
        int pin = sc.nextInt();
        if(customers.get(ac_no) != null && customers.get(ac_no).pin != pin) {
            System.out.println("Invalid ac_no or pin");
            return;
        }
        Customer customer = customers.get(ac_no);
        System.out.println(customer.name);
        
        boolean loop = true;
        
        while(loop) {
            System.out.print("1. Check Balance \n2. Withdraw money \n3. Transfer Money \n4. Mini Statement \n5. Exit \nEnter option : ");
            int option = sc.nextInt();
            switch(option) {
                case 1:
                {
                    System.out.println(customer.balance);
                    break;
                }
                case 2:
                {
                    withdraw(customer);
                    break;
                }
                case 3:
                {
                    transfer(customer);
                    break;
                }
                case 4:
                {
                    miniStatement(customer);
                    break;
                }

            }
        }
    }
    
    
    
    static void withdraw(Customer customer) {
        System.out.print("Enter pin number : ");
        int pin = sc.nextInt();
        if(pin != customer.pin) {
            System.out.println("wrong pin");
            return;
        }
        System.out.print("Enter amount : ");
        int amount = sc.nextInt();
        if(amount<100 || amount>10000) {
            System.out.println("withdraw amount is not within range");
            return;
        }
        if(total_amount<amount) {
            System.out.println("Not enough cash in ATM");
            return;
        }
        if(customer.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        
        if(amount <= 5000) {
            int r_amount = amount,r1 = 0, r2 = 0,r3 = 0;
            if(r_amount>1000) {
                r1 = 1;
                r_amount -= 1000;
            }
            if(r_amount>1000) {
                    r2 = r_amount/500;
                    r_amount -= r2*500;
            } 
            r3 = r_amount / 100;
            if(r_amount % 100 != 0) {
                    System.out.println("Entered amount not in proper denominations");
                    return;
            }
            customer.balance -= amount;
            total_amount -= amount;
            denomination.put(1000,denomination.get(1000)-r1);
            denomination.put(500,denomination.get(500)-r2);
            denomination.put(100,denomination.get(100)-r3); 
            System.out.println("Balance after withdrawl : " + customer.balance); 
            
            String remark = "Debited " + amount + " from ATM";
            Transaction transaction = new Transaction(remark,"debit",amount); 
            customer.transactions.add(transaction);       
        }
        else {
            int r_amount = amount,r1 = 0, r2 = 0,r3 = 0;
            if(r_amount>1000) {
                r1 = 3;
                r_amount -= 3000;
            }
            if(r_amount>1000) {
                    r2 = r_amount/500;
                    r_amount -= r2*500;
            } 
            r3 = r_amount / 100;
            if(r_amount % 100 != 0) {
                    System.out.println("Entered amount not in proper denominations");
                    return;
            }
            customer.balance -= amount;
            total_amount -= amount;
            denomination.put(1000,denomination.get(1000)-r1);
            denomination.put(500,denomination.get(500)-r2);
            denomination.put(100,denomination.get(100)-r3);
            System.out.println("Balance after withdrawl : " + customer.balance); 
            
            String remark = "Debited " + amount + " from ATM";
            Transaction transaction = new Transaction(remark,"debit",amount);  
            customer.transactions.add(transaction);          
        }
    }
    
    public static void transfer(Customer customer) {
        System.out.print("Enter receiver ac_no : ");
        int rc_no = sc.nextInt();
        Customer receiver = customers.get(rc_no);
        if(receiver == null) {
            System.out.println("customer ont found");
            return;
        }
        System.out.print("Enter amount : ");
        int amount = sc.nextInt();
        if(customer.balance - amount < 1000) {
            System.out.println("Insufficient balance");
            return;
        }
        if(total_amount < amount) {
            System.out.println("Not enough cash in ATM");
            return;
        }
        if(amount < 1000 || amount > 10000) {
            System.out.println("amount not in range");
            return;
        }
        
        customer.balance -= amount;
        receiver.balance += amount;
        System.out.println(customer.name + " balance : " + customer.balance);
        System.out.println(receiver.name + " balance : " + receiver.balance);
        
        String remark = "fund transfer to account " + receiver.ac_no;
        Transaction transaction = new Transaction(remark,"Credit",amount);
        customer.transactions.add(transaction);
    }
    
    
    public static void miniStatement(Customer customer) {
        System.out.println("Transaction ID    Transaction Remark    Transaction Type     Transaction Amt");
        ArrayList<Transaction> transactions = customer.transactions;
        for(int i=transactions.size()-1,j=0;i>=0 && j<5;i--,j++) {
            transactions.get(i).getTransaction();
        }
    }
}

public class ATMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        // create customers
        ATM.customers.put(101,new Customer(101,"Suresh",2343,25234));
        ATM.customers.put(102,new Customer(102,"Ganesh",5432,34123));
        ATM.customers.put(103,new Customer(103,"Magesh",7853,26100));
        ATM.customers.put(104,new Customer(104,"Naresh",2345,80000));
        ATM.customers.put(105,new Customer(105,"Harish",103400,80000));    
        
        boolean loop = true;
        while(loop) {
            System.out.print("1. Load cash to ATM \n2. Show Customer Details \n3. Show ATM Operations \n4. Exit \nEnter option : ");
            int option = sc.nextInt();
            switch(option) {
                case 1:
                {
                    ATM.loadCash();
                    break;
                }
                case 2:
                {
                    ATM.showCustomers();
                    break;
                }
                case 3:
                {
                    ATM.menuPage();
                    break;
                }
                case 4:
                {
                    loop = false;
                    break;
                }
                default:
                    System.out.println("Invalid");
            }
        }
    }
}