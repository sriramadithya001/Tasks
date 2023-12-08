import java.util.*;


public class ATM{

		static ArrayList<Customer> clist = new ArrayList<>();
		
		static int thousands = 1000;
		static int fhundrads = 500;
		static int hundrd = 100;
		
		public static void customerDetails(){
		
			System.out.println("ACC No " + "     " + "Acc Holder" + "     " + "PiN" + "     " + " Balance" );
			
			for(Customer c: clist){
				System.out.println(c.Accno + "   " + c.name + "   " + c.pin + "   " + c.balance);
			}
		}
		
		public static void loadCash(){
		
			thousands = 20*thousands;
			fhundrads = 100*fhundrads;
			hundrd = 300*hundrd;
		
				
		}
		
		public static void miniState(Customer c){
		
			System.out.println("Tranaction ID " + "   " + "Transaction Remarks " + "   " +  "Transaction type" + "    " + "Transaction AMt");
		
			for(int i = c.tlist.size()-1;i>=0;i--){
				Transaction t = c.tlist.get(i);
				System.out.println(t.id + "          "  + t.remarks + "          " + t.type + "         " + t.amount);
			}
		
		}
		
		public static void transfer(Customer c){
		
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter the Accoutn number your want to transfer");
			
			int ac = sc.nextInt();
			
			System.out.println("Enter the amount to be transfer");
			
			int am = sc.nextInt();
			
			if(am > 10000 || am < 1000){
				System.out.println("Max transfer: 10,000 & Min transfer : 1000");
				return;
			}
			
			for(Customer c1: clist){
				if(c1.Accno == ac){
					c1.balance += am;
					System.out.println("Amount credited to" + c1.name + " is Successfully");
					String rm = "Funds transfer from Acc "+ c.Accno;
					Transaction t = new Transaction(am, rm, "Credit");
					c1.tlist.add(t);
					c.balance -= am;
					String rm2 = "Funds transfer to Acc " + c1.Accno;
					Transaction t2 = new Transaction(am, rm2, "Debit");
					c.tlist.add(t2);
					

				}
			}
		
		}
		
		public static void withdraw(Customer c){
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter the amount to be Withdraw");
			int amount = sc.nextInt();
			int am = amount;
			if(amount > 10000 || amount<100) {
			System.out.println("Max withdrawal : 10,000 & Min withdrawal : 100");
			return;
			}
			
			if(amount > c.balance){
				System.out.println("Enteres amount is greater than your balance!");
				return;
			}
			
			if(amount <= 5000){
				if(amount > 1000){ 
				  amount -= 1000;
				  thousands -= 1000;
				  if(amount > 500){
				  	int d = amount%500;
				  	amount -= (d*500);
				  	fhundrads -= (d*500);
				  }
				  if(amount == 0) System.out.println("Amount debited successfully");
				  else if(amount > 0){
				  	int d2 = amount%100;
				  	amount -= (d2*100);
				  	hundrd -= (d2*100);
				  	System.out.println("Amount debited Sucessfully");
				  }
			   }else{
			   	int d3 = amount%100;
			   	hundrd -= (d3 * 100);
			   	System.out.println("Amount debited Sucessfully");
			   }
			}else if(amount > 5000){
				
				   amount -= 3000;
				  thousands -= 3000;
				  if(amount > 500){
				  	int d = amount%500;
				  	amount -= (d*500);
				  	fhundrads -= (d*500);
				  }
				  if(amount == 0) System.out.println("Amount debited successfully");
				  else if(amount > 0){
				  	int d2 = amount%100;
				  	amount -= (d2*100);
				  	hundrd -= (d2*100);
				  	System.out.println("Amount debited Sucessfully");
				  }
				
			}
			
			c.balance -= am;
			
			String rm = "Debited" + am + " from ATM";
			
			Transaction t = new Transaction(am, rm, "ATM");
			c.tlist.add(t);
			
		}
		
		public static void goATM(){
			Scanner sct = new Scanner(System.in);
			Customer c = null;
			System.out.println("Enter your Account number");
			int ac = sct.nextInt();
			System.out.println("Enter your PIN");
			int pin = sct.nextInt();
			boolean b = false;
			for(Customer sc : clist){
				if(sc.Accno == ac && sc.pin == pin){
					c = sc;
					b = true;
					System.out.println("Welcome" + sc.name + " !");
				}
			}
			
			if(!b){
				System.out.println("Not a valid user!");
				return;
			}
			
			boolean b1 = true;
			
			while(b1){
			
			System.out.println("1.Check Balance  \n" + "2. Withdraw Money  \n" + "3. Transfer Money  \n" + "4.Mini statement ");
			System.out.println("Enter the key to select the option");
			int n = sct.nextInt();
			
			
			
			if(n == 1){
				System.out.println("Your current Balance : " + c.balance);
			}else if(n == 2) withdraw(c);
			else if(n == 3) transfer(c);
			else if(n == 4) miniState(c);
			else if(n == 0) {
				b1 = false;
				break;
			}
			}
			
		}


		public static void main(String[] args){
		
		
				Scanner sc = new Scanner(System.in);
				
				Customer c1 = new Customer(101, "Suresh", 2343, 25234);
				clist.add(c1);
				Customer c2 = new Customer(102, "Ganesh", 5432, 34123);
				clist.add(c2);
				Customer c3 = new Customer(103, "Magesh", 7854, 26100);
				clist.add(c3);
				Customer c4 = new Customer(104, "Naresh", 2345, 80000);
				clist.add(c4);
				Customer c5 = new Customer(105, "Harish", 1907, 103400);
				clist.add(c5);
				
				boolean b = true;
				
				while(b){
				
				System.out.println("1. Load cash to ATM" + " \n" +  "2. Show Customer details " + " \n" + "3. Show ATM operations ");
				System.out.println("Enter the key to select");
				int n = sc.nextInt();
				
				if(n==1) loadCash();
				else if(n==2) customerDetails();
				else if(n==3) goATM();
				else if(n==0){
					b = false;
					break;
				}
				
				}
				
				
		}
}

class Customer{
	ArrayList<Transaction> tlist = new ArrayList<>();
	int Accno;
	String name;
	int pin;
	int balance;
	
		public Customer(int Accno, String name, int pin, int balance){
		
			this.Accno = Accno;
			this.name =  name;
			this.pin = pin;
			this.balance = balance;
		}
}

class Transaction{

	int id;
	static int num = 0;
	String remarks;
	String type;
	int amount;
	
		public Transaction(int amount, String remarks, String type){
			this.amount = amount;
			this.remarks = remarks;
			this.type = type;	
			num++;
			this.id = num;
		}

}