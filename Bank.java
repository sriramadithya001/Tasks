import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Bank extends Thread{
	 static int balance = 100;
	 static String password = "1234";
         static String filename = "structured_data.txt";

        
	synchronized  public static void withdraw(String name, int n){
	   
	   if(n<balance){
	    balance-=n;
 	    System.out.println("Name" + name + "Balance : "+(balance+n )+ "withdrawal : " + n + " comment" + name + " is withdrwaed" + n + "balance"+ balance);
	    
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name" + name + "Balance : "+(balance+n )+ "withdrawal : " + n + " comment" + name + " is withdrwaed" + n + "balance"+ balance);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	   }else{
	    System.out.println("Less balance");
	  }
	  
	}	
	synchronized public static void deposit(String name, int n){
	 
	  balance+=n;
	  System.out.println("Name" + name + "Balance : "+(balance-n )+ "Deposit : " + n + " comment" + name + " is deposited" + n + "balance"+ balance);
	
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write("Name" + name + "Balance : "+(balance-n )+ "Deposit : " + n + " comment" + name + " is deposited" + n + "balance"+ balance);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

	public static void main(String[] args){
	   Scanner sc = new Scanner(System.in);
	   String s = "ArnabMonodwipMuktaRinkelShubhum";
	   while(true){
	   System.out.println("Enter your name to initiate transaction");
	   String name = sc.next();
	   if(s.contains(name)){
            
	    System.out.println("Entered your password");
	    String pw  = sc.next();
            if(pw.equals(password)){
	    
	    System.out.println("1. withdraw\n" + "2. deposit\n" + "3.getBalance");
	    int n = new Scanner(System.in).nextInt();
	      if(n==1){
	        System.out.println("Enter the amount");
	 	int am = sc.nextInt();
	         Withdraw.amount = am;
	        Withdraw w = new Withdraw(name);
	        w.start();
	      }else if(n==2){
	        System.out.println("Enter the amount");
	 	int am = sc.nextInt();
	        Deposit.amount = am;
	        Deposit d = new Deposit(name);
	        d.start();
	      }
	   }
	    else {
		System.out.println("Entered password is wrong");
	    }
	   }else{
	    System.out.println("Entered name is not registered");
	   }
	   }
	   
	}
}
class Withdraw extends Thread{

      public Withdraw(String name){
	super(name);
     }
     static int amount  = 0;

       public  void run(){

	  System.out.println("1. withdraw\n" + "2. deposit\n" + "3.getBalance");
	  Bank.withdraw(getName(), amount);
	  /*int n = new Scanner(System.in).nextInt();
	      if(n==1){
	        System.out.println("Hey hello");
	        Bank.withdraw("name");
	      }else if(n==2){
	        
	      }*/
	   
	}

}

class Deposit extends Thread{

	 public Deposit(String name){
	super(name);
        }
	static int amount  = 0;

	public void run(){
	   Bank.deposit(getName(), amount);
	}

}

