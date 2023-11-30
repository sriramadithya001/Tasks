public class Ticket{
	 
	String pnr, curr_status, berth_type, name, age;
	int berthNo;
	
	Ticket(String pnr , int berthNo, String curr_status, String berth_type, String name, String age){
		this.pnr = pnr;
		this.berthNo = berthNo;
		this.curr_status = curr_status;
		this.berth_type = berth_type;
		this.name = name;
		this.age = age;
	}
	
	public void printTicket(){
		System.out.println(pnr+" "+berthNo+" "+curr_status+" "+berth_type+" "+name+" "+age);
	}
}