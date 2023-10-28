import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class Purchase {
    String userName;
    String productName;
    int cost;

    Purchase(String userName, String productName, int cost) {
	this.userName = userName;
	this.productName = productName;
	this.cost = cost;
    }
}

class Product {
    String name;
    int price;
    String couponCode;
    int quantity;

    Product(String name,int price,String couponCode,int quantity) {
	this.name = name;
	this.price = price;
	this.couponCode = couponCode;
	this.quantity = quantity;
    }
}


class Admin {
    final static String AdminName = "john", AdminPassword = "println";
    static int orderedCount = 0,  productCount = 0;
    static int discountPercent = 15;
    static HashMap<String, Product> products = new HashMap<>();
    static ArrayList<Purchase> bills = new ArrayList<>();

    // files
    static File billFile = new File("C:\\Users\\Administrator\\Desktop\\sriram\\Test\\L3Test\\BillHistory.txt");
    static File productFile = new File("C:\\Users\\Administrator\\Desktop\\sriram\\Test\\L3Test\\Products.txt");

    static int discount(int price) {
	return price * discountPercent / 100;
    }

    static void addProduct() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter product name : ");
	String name = sc.next();
	System.out.print("Enter product price : ");
	int price = sc.nextInt();
	System.out.print("Generate couponCode : ");
	String couponCode = sc.next();
	System.out.print("Enter product quantity : ");
	int quantity = sc.nextInt();
	Product product = new Product(name,price,couponCode,quantity);
	products.put(name,product);
	System.out.println(name + " ,added successfully");




	// Add to Product file

	
	try(FileWriter writer = new FileWriter(productFile, true)) {
	    ++productCount;
	    String productDetail = "Product ID : " + productCount + "\n" + "Product name : " + name + "\n" + "Product price : " + price + "\n" + "Coupon code : " + couponCode + "\n" + "Quantity : " + quantity + "\n";
	    writer.write(productDetail);
	    writer.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in file");
	}
    }

    static void checkAvailabilty() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter product name : ");
	String name = sc.next();
	System.out.println(name + " stock : " + products.get(name).quantity);
    }

    static void shoppingHistory() {
	for(Purchase purchase : bills) {
	    System.out.println("customer name : " + purchase.userName);
	    System.out.println("product name : " + purchase.productName);
	    System.out.println("product cost : " + purchase.cost);
	}
    }

    static void loggedIn() {
	Scanner sc = new Scanner(System.in);
	System.out.println("\t\tADMIN MENU");
	boolean back = false;
	while(!back) {
	    System.out.println("1. Add Product");
	    System.out.println("2. Shopping History");
	    System.out.println("3. checkAvailability");
	    System.out.println("4. Back");
	    System.out.print("Enter your option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		    addProduct();
		    break;
		case 2:
		    shoppingHistory();
		    break;
		case 3:
		    checkAvailabilty();
		    break;
		case 4:
		    System.out.println("Exiting Admin Menu");
		    back = true;
		    break;
		default:
		    System.out.println("Enter a valid option");
	    }
	}
    }
}

class User {
    final static String userName = "jim", userPassword = "cout";
    static ArrayList<Product> OrderedItems = new ArrayList<>();

    static void orderItem() {
	Scanner sc = new Scanner(System.in);
	productList();
	System.out.print("product name : ");
	String productName = sc.next();
	System.out.print("Coupon Code : ");
	String couponCode = sc.next();
	Product product = Admin.products.get(productName);
	OrderedItems.add(Admin.products.get(productName));
	product.quantity--;

	int cost = product.price;
	if(couponCode.equals(product.couponCode)) cost -= Admin.discount(price);

	Purchase purchase = new Purchase(userName, productName, cost);
	Admin.bills.add(purchase);

	System.out.println(productName + " added successfully");




	// Add to bill History file

	
	try(FileWriter writer = new FileWriter(Admin.billFile, true)) {
	    Admin.orderedCount++;
	    String bill = "Bill ID : " + Admin.orderedCount + "\n" + "Customer name : " + userName + "\n" + "Product name : " + productName + "\n" + "Product price : " + cost + "\n";
	    writer.write(bill);
	    writer.close();
	}
	catch(Exception e) {
	    System.out.println("An error occured in file");
	}


	
    }


    static void cancelItem() {
	Scanner sc = new Scanner(System.in);
	System.out.print("product name : ");
	String productName = sc.next();
	OrderedItems.remove(Admin.products.get(productName));
	Admin.products.get(productName).quantity++;
	System.out.println(productName + " , removed successfully");
    }

    static void productList() {
        int cnt = 0;	
        for(String name : Admin.products.keySet()) {
		if(Admin.products.get(name).quantity>0) System.out.println(++cnt + " " + name);
	}
    }

   static void loggedIn() {
	Scanner sc = new Scanner(System.in);
	System.out.println("\t\tUSER MENU");

        boolean back = false;
	while(!back) {
	    System.out.println("1. Products");
	    System.out.println("2. Order");
	    System.out.println("3. Cancel Order");
	    System.out.println("4. Back");
	    System.out.print("Enter an option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		{
		    productList();
		}
		break;
		case 2:
		{
		    orderItem();
		}
		break;
		case 3:
		{
		    cancelItem();
		}
		case 4:
		{
		    System.out.println("Exiting User Menu..");
		    back = true;
		}
		break;
		default:
		    System.out.println("Enter a valid option");
	    }
        }
    }
}

public class OnlineShoppingApplication {

    public static void homepage() {
	Scanner sc = new Scanner(System.in);
	System.out.println("\t\tONLINE SHOPPING APP");
	boolean back = false;
	while(!back) {
	    System.out.println("Login");
	    System.out.println("1. Admin");
	    System.out.println("2. User");
	    System.out.println("3. Back");
	    System.out.print("Enter an option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		{
		    System.out.print("Enter your name : ");
		    String name = sc.next();
		    System.out.print("Enter your password : ");
		    String password = sc.next();
		    if(name.equals(Admin.AdminName) && password.equals(Admin.AdminPassword)) Admin.loggedIn();
		    else System.out.println("Incorrect name or password");
		}
		break;
		case 2:
		{
		    System.out.print("Enter your name : ");
		    String name = sc.next();
		    System.out.print("Enter your password : ");
		    String password = sc.next();
		    if(name.equals(User.userName) && password.equals(User.userPassword)) User.loggedIn();
		    else System.out.print("Incorrect name or password");
		}
		break;
		case 3:
		{
		    System.out.println("Exiting the Application..");
		    back = true;
		}
		break;
		default:
		    System.out.println("Enter a valid option");
	    }
    	}
    }

    public static void main(String[] args) {
	homepage();
    }
}