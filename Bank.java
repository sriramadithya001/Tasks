import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;




public class Bank{

static ArrayList<Customer> clist = new ArrayList<>();


static int transid = 0;

public static String Encrp(String s){
	
	String t="";
	
	for(int i=0;i<s.length();i++){
		t+= (char)(s.charAt(i) + 1);
	}
	
	return t;
}

public static void maint(){

	for(Customer c: clist){
		if(c.tcount>=3){
			c.balance -= 100;
			System.out.println("Maintance fee debited");
			try (PrintWriter writer = new PrintWriter(new FileWriter("trans_history.txt", true))) {
           
            writer.println(c.name+" "+c.accno+" "+(transid++)+" "+"Maintance fee"+" "+"100"+" "+c.balance); 
        } catch (IOException e) {
            e.printStackTrace();
        }

		}
	}
}

public static void topCus(){
	
	System.out.println("Enter the number of customers u need");
	int n = new Scanner(System.in).nextInt();
	
	Collections.sort(clist, (a,b)->b.balance - a.balance);
	
	for(int i=0;i<n;i++){
		
		Customer c = clist.get(i);
		System.out.println(c.name + "  "+ c.accno +" "+ c.balance);
	}
}

public static void acctrans(){
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter your customer id");
	int id  = sc.nextInt();
	System.out.println("Enter your beneficiary's id");
	int id2 = sc.nextInt();
	System.out.println("Enter the amount to be transfer");
	int amount = sc.nextInt();
	for(Customer c: clist){
		if(id == c.id){
			if(c.tcount>=5){
				System.out.println("You should need to change your password");
				return;
			}

			int bal = c.balance-1000;
			if(amount>bal){
				System.out.println("Enteres amount is greater than yout balance");
			}else{
				if(amount>5000){
					amount +=10;
				}
				c.balance -= amount;
				c.tcount++;
				try (PrintWriter writer = new PrintWriter(new FileWriter("trans_history.txt", true))) {
           
            writer.println(c.name+" "+c.accno+" "+(transid++)+" "+"Account transfer"+" "+amount+" "+c.balance); 
        } catch (IOException e) {
            e.printStackTrace();
        }

				
			}

		}
		if(id2 == c.id){
			c.balance += amount;
			c.tcount++;
			System.out.println("Amoutn transfered successfully");
			try (PrintWriter writer = new PrintWriter(new FileWriter("trans_history.txt", true))) {
           
            writer.println(c.name+" "+c.accno+" "+(transid++)+" "+"Account transfer"+" "+amount+" "+c.balance); 
        } catch (IOException e) {
            e.printStackTrace();
        }

		}
	}
	
}

public static void Atmw(){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter yout customer id");
	
	int id = sc.nextInt();
	System.out.println("Enter the amount to withdraw");
	int amount  = sc.nextInt();
	
	for(Customer c: clist){
		if(id == c.id){
			if(c.tcount>=5){
				System.out.println("You should need to change your password");
				return;
			}

			int bal = c.balance-1000;
			if(amount>bal){
				System.out.println("Enteres amount is greater than yout balance");
			}else{
			
			  c.balance -= amount;
			  c.tcount++;
			  System.out.println("Amount withdrawed successfully");
			  try (PrintWriter writer = new PrintWriter(new FileWriter("trans_history.txt", true))) {
           
            writer.println(c.name+" "+c.accno+" "+transid+" "+"ATM withdrwal"+" "+amount+" "+c.balance); 
        } catch (IOException e) {
            e.printStackTrace();
        }

			
			}
		}
	}

}

public static void cashDeposit(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter yout customer id");
	
	int id = sc.nextInt();
	System.out.println("Enter the amount to be deposit");
	int amount = sc.nextInt();
	
	for(Customer c : clist){
		if(c.id == id){
			if(c.tcount>=5){
				System.out.println("You should need to change your password");
				return;
			}
			c.balance = c.balance + amount;
			c.tcount++;
			System.out.println("Amout deposited successfully");
			try (PrintWriter writer = new PrintWriter(new FileWriter("trans_history.txt", true))) {
           
            writer.println(c.name+" "+c.accno+" "+(transid++)+" "+"CashDeposit"+" "+amount+" "+c.balance); 
        } catch (IOException e) {
            e.printStackTrace();
        }

			break;
		}
	}
	
}

public static void login(){

	Scanner sc =  new Scanner(System.in);
	
	System.out.println("Enter your customer id :");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter your password");
	String psw = sc.next();
	
	for(Customer c: clist){
		if(id == c.id){
			if(c.password.equals(psw)){
			
				System.out.println("Welcome to the banking portal");
			}
		}
	}
}

public static void changepsw(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the customer id");
	int id = sc.nextInt();
	System.out.println("Enter the new password");
	String ps = sc.next();
	boolean b = false;
	for(Customer c: clist){
		if(id == c.id){
			for(String s: c.plist){
				if(s.equals(ps)){
					System.out.println("New password shouldn't be old one");
					return;
				}
			}
			b=true;
			
		}
	}
	if(validate(ps) && b){
		for(Customer c: clist){
			if(id == c.id){
				c.password = ps;
				c.plist.add(ps);
				System.out.println("Password changes successfully");
				break;
			}
			
		}
	}
	
	}

public static boolean validate(String s){

	
     String regex = "[a-z]{2}[A-Z]{2}[0-9]{2}";

     Pattern p = Pattern.compile(regex);
    
     Matcher m = p.matcher(s);

     if(m.matches()){ return true;
      }else{
       return false;
       
            }


}
	

public static void newCustomer(){

	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter the name");
	String name = sc.next();
	System.out.println("Enter the password");
	String ps1 = sc.next();
	if(validate(ps1)){
		System.out.println("password is valid");
	}
	else{
		System.out.println("password complexity is low..");
		return;
	}
	System.out.println("Retype your password");
	String ps2 = sc.next();
	if(ps1.equals(ps2)){
		
		Customer c = new Customer(name, ps1);
		c.plist.add(ps1);
		clist.add(c);
		System.out.println("New customer added successfully");
		System.out.println("Your id is" + c.id);
		
		String Encrp = Encrp(ps1);
		
	try (PrintWriter writer = new PrintWriter(new FileWriter("bank_db.txt", true))) {
           
            writer.println(c.name+ "  "+c.accno+" "+c.name+" "+c.balance+" "+Encrp);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	
	}else{
		System.out.println("Password didn't match");
	}
}

public static void intialize(){
		
	   System.out.println("CusID " +   "Account No " + "Name" + "Balance" + "Encrptedpwd");
        try (BufferedReader reader = new BufferedReader(new FileReader("bank_db.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("");
                 System.out.println(parts[0] + parts[1] + parts[2] + parts[3]);
               }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		}


		public static void main(String[] args){
		
			Scanner sc = new Scanner(System.in);
			
			//System.out.println("CusID " +   "Account No " + "Name" + "Balance" + "Encrptedpwd");

			//Customer c = new Customer();
			
			boolean b = true;
			
			while(b){
			
			System.out.println("1.addNewCustomer \n" + "2. login \n" +"3.Transaction \n"  + "4. top n customer \n" + "5. Change Password" );
			int n = sc.nextInt();
			if(n==1){
			newCustomer();
			}
			else if(n==2){
			login();
			}else if(n==3){
				System.out.println("1.Cash Deposit \n" + "2.ATM withdrwal \n" + "3.Account transfer ");
				maint();
				int m = sc.nextInt();
				if(m==1) cashDeposit();
				else if(m==2) Atmw();
				else if(m==3) acctrans();
			}
			else if(n==4) topCus();
			else if(n==5) changepsw();

			else{
			 b= false;
			 break;
			}
			}
			
			
		
		}

}

class Customer{

	static int num = 0;
	static int ac = 100;
	int id;
     int accno;
	String name;
	String password;
	int balance = 10000;
	int tcount = 0;
	ArrayList<String> plist = new ArrayList<>();
	public Customer(String name, String password){
		this.name = name;
		this.password = password;
		num++;
		ac++;
		this.id  = num;
		this.accno = ac;
	}
	
	
}




