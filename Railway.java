import java.util.*;

public class Railway{
	static int berthNo = 1001; 
	static int PNR = 583639; 

	static ArrayList<Ticket> confirmedTickets = new ArrayList<>();
	static ArrayList<Ticket> racTickets  = new ArrayList<>();
	static ArrayList<Ticket> wlTickets = new ArrayList<>();
	static Map<String, Integer> map = new LinkedHashMap<>();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		createCabins(2,2,2,2,2,2,2);
		while(true){
			System.out.print("1.Book 2.Cancel 3.PrintTickets 4.printPassegerDetails 5.Exit : ");
			String choice = in.next();
			switch(choice){
				case "1" -> bookPassenger();
				case "2" -> cancelPassenger();
				case "3" -> printTickets();
				case "4" -> printPassengerDetails();
				case "5" -> System.exit(0);
				default -> System.out.print("Invalid..!");
			}
		}
	}
	
	private static void createCabins(int ub, int mb, int lb, int su, int rac, int wl, int cabin){
		map.put("lb", lb*cabin);
		map.put("ub", ub*cabin);
		map.put("mb", mb*cabin);
		map.put("su", su*cabin);
		map.put("rac", 2*rac*cabin);
		map.put("wl", wl*cabin);
		
		generateTickets();
	}
	
	private static void generateTickets(){
		for(Map.Entry<String, Integer> ans : map.entrySet()){
			if(ans.getKey().equals("ub") || ans.getKey().equals("mb") || ans.getKey().equals("lb") || 
			ans.getKey().equals("su")){
				generateConfirmedBerths(ans.getKey(), ans.getValue());
			}
			else if(ans.getKey().equals("rac")) generateRacBerths(ans.getKey(), ans.getValue());
			else generateWaitingList(ans.getKey(), ans.getValue());
		}
	}
	
	private static void generateConfirmedBerths(String berthType, int berthsToAdd){
		for(int i=0;i<berthsToAdd;i++){
			confirmedTickets.add(new Ticket("-", berthNo++, "AVL", berthType, "-", "-"));
		}
	}
	
	private static void generateRacBerths(String berthType, int berthsToAdd){
		int berths = 1;
		for(int i=0;i<berthsToAdd;i++){
			racTickets.add(new Ticket("-", berthNo, "RAC", berthType, "-", "-"));
			if(berths % 2 == 0) berthNo++;
			berths++;
		}
	}
	
	private static void generateWaitingList(String berthType, int berthsToAdd){
		for(int i=0;i<berthsToAdd;i++){
			wlTickets.add(new Ticket("-",-1, "WL", berthType, "-", "-"));
		}
	}
				//      BOOKING PASSENGER
	private static void bookPassenger(){
		System.out.print("1.Single 2.Group : ");
		String choice = in.next();
		if(choice.equals("1")) singlePassenger();
		if(choice.equals("2")) groupPassenger();
		else return;
	}
	
	private static void singlePassenger(){
		System.out.print("Enter Name: ");
		String name = in.next();
		System.out.print("Enter age: ");
		int age = in.nextInt();
		System.out.print("Enter preferred Berth : ");
		String preferredBerth = in.next();
		int ticketsNeeded = 1;
		if(preferredBerth .equals("rac") || preferredBerth .equals("wl")) return;
		if(map.get(preferredBerth ) >= ticketsNeeded) System.out.println("Preferred Berth Available..!");
		else{
			System.out.print("Not Available. Search for other berths?? 1(Yes) . 2(No) : ");
			String choice = in.next();
			if(choice.equals("1")) allotBerths(name, age, preferredBerth, true);
			return;
		}
		allotBerths(name, age, preferredBerth, true);
	}

	private static void allotBerths(String name, int age, String berth, boolean single){
		for(Ticket ticket : confirmedTickets){
			if(ticket.pnr.equals("-") && ticket.berth_type.equals(berth)){
				ticket.pnr = String.valueOf(PNR);
				if(single) PNR++;
				ticket.name = name;
				ticket.curr_status = "CNF";
				ticket.age = String.valueOf(age);
				System.out.println("Ticket booked..!");
				map.replace(berth, map.get(berth)-1);
				return;
			}
		}	
		for(Ticket ticket : racTickets){
			if(ticket.pnr.equals("-")){
				ticket.pnr = String.valueOf(PNR++);
				ticket.name = name;
				ticket.curr_status = "CNF";
				ticket.age = String.valueOf(age);
				System.out.println("RAC Ticket booked..!");
				map.replace(berth, map.get(berth)-1);
				return;
			}
		}
		for(Ticket ticket : wlTickets){
			if(ticket.pnr.equals("-")){
				ticket.name = name;
				ticket.pnr = String.valueOf(PNR++);
				ticket.curr_status = "CNF";
				ticket.age = String.valueOf(age);
				System.out.println("WL Ticket booked..!");
				map.replace(berth, map.get(berth)-1);
				return;
			}
		}

	}

	private static void groupPassenger(){
		System.out.print("Enter preferred Berth : ");
		String preferredBerth = in.next();
		System.out.print("total Tickets : ");
		int ticketsNeeded = in.nextInt();
		if(preferredBerth .equals("rac") || preferredBerth .equals("wl")) return;
		if(map.get(preferredBerth ) >= ticketsNeeded) System.out.println("Berth Available..!");
		else{
			System.out.println("You can't travel as a family..! ");
			return;
		}
		for(int i=0;i<ticketsNeeded; i++){
			System.out.print("Enter Name: ");
			String name = in.next();
			System.out.print("Enter age: ");
			int age = in.nextInt();
			allotBerths(name, age, preferredBerth, false);
		}
		PNR++;
	}


				//      CANCEL PASSENGER
	private static void cancelPassenger(){
		System.out.print("Enter PNR :");
		String pnr = in.next();
		for(Ticket ticket : confirmedTickets){
			if(ticket.pnr.equals(pnr)){
				ticket.pnr = "-";
				ticket.name = "-";
				ticket.age = "-";
				return;
			}
		}
		
		for(Ticket ticket : racTickets){
			if(ticket.pnr.equals(pnr)){
				ticket.pnr = "-";
				ticket.name = "-";
				ticket.age = "-";
				return;
			}
		}
		
		for(Ticket ticket : wlTickets){
			if(ticket.pnr.equals(pnr)){
				ticket.pnr = "-";
				ticket.name = "-";
				ticket.age = "-";
				return;
			}
		}


	}
	
				//      PRINT TICKETS
	private static void printTickets(){
		System.out.println("************CONFIRMED BERTHS**************");
		for(Ticket ticket : confirmedTickets) ticket.printTicket();
		System.out.println("************RAC BERTHS**************");
		for(Ticket ticket : racTickets) ticket.printTicket();
		System.out.println("************WL BERTHS**************");
		for(Ticket ticket : wlTickets) ticket.printTicket();
		
	}
	
				//      PRINT PASSENGER BOOKED DETAILS
	private static void printPassengerDetails(){
		System.out.print("Enter PNR :");
		String pnr = in.next();
		for(Ticket ticket : confirmedTickets){
			if(ticket.pnr.equals(pnr)){
				ticket.printTicket();
				return;
			}
		}
		
		for(Ticket ticket : racTickets){
			if(ticket.pnr.equals(pnr)){
				ticket.printTicket();
				return;
			}
		}
	}	
}