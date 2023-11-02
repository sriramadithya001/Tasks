import java.util.*;
public class Parking{

	static int cp = 50;
	static int bp = 10;

	public static void parkCar(ArrayList<CarLot> carlist, HashMap<String, String> vlist){
		System.out.println("Enter the lot you want to park");
	  	char c = new Scanner(System.in).next().charAt(0);
		System.out.println("Enter your vehicle number");
		String number = new Scanner(System.in).next();
		for(CarLot lot: carlist){
	  		if(c==lot.name){
			   if(lot.capacity<=0){
				System.out.println("Entered lot is already full");
				break;
			   }else{
				String lname = lot.name+" "+lot.capacity;
			    	lot.capacity-=1;
		  		
	  			vlist.put(number, lname);
				System.out.println("You can park your vehicle at "+ lname);
			   }
			}
	        }
	}
	public static void parkCar(ArrayList<BikeLot> bikelist, HashMap<String, String> vlist){
		System.out.println("Enter the lot you want to park");
	  	char c = new Scanner(System.in).next().charAt(0);
		System.out.println("Enter your vehicle number");
		String number = new Scanner(System.in).next();
		for(BikeLot lot: bikelist){
	  		if(c==lot.name){
			   if(lot.capacity<=0){
				System.out.println("Entered lot is already full");
				break;
			   }else{
				String lname = lot.name+" "+lot.capacity;
			    	lot.capacity-=1;
		  		
	  			vlist.put(number, lname);
				System.out.println("You can park your vehicle at "+ lname);
			   }
			}
	        }
	}
	
	public static void main(String[] args){
	  ArrayList<CarLot> carlist  = new ArrayList<>();
	  ArrayList<BikeLot> bikelist = new ArrayList<>();
	  HashMap<String, String> vlist = new HashMap<>();
	
	  for(int i=0;i<25;i++){	 
	     BikeLot c = new BikeLot((char)('A'+i));	
	     carlist.add(c);
	  }
	 

	  for(int i=0;i<25;i++){	 
	     CarLot c = new CarLot((char)('A'+i));	
	     carlist.add(c);
	  }
	 
	  System.out.printl("1. park the vehicle" + "2. Exit");
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  if(n==1){	 
	     System.out.println("Enter your vehicle Car/Bike");
	     String veh = sc.next();
	     if(veh.equalsIgnoreCase("Car")){
	        parkCar(carlist, vlist);
	     }else if(veh.equalsIgnoreCase("Bike")){	
		parkBike(bikelist, vlist);
	     }
	  }
	  
	}
}

class BikeLot{

   char name;
   int capacity = 5;
	public BikeLot(char name){
	   this.name = name;
	}
}

class CarLot{	

char name;
   int capacity = 5;
	public CarLot(char name){
	   this.name = name;
	}
}