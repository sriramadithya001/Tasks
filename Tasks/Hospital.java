

public class Hospital{
           static String Doctor = "11 AM";
	   static M_P1 = "11 AM";
	   statci M_p2 = "11 AM";

	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
          ArrayList<Patient> record = new ArrayList<>();
	  System.out.println("Hey..Welcome to L3 Hospital");
	  System.out.println("Enter patient name");
	  String pname = sc.next();
	  System.out.println("Enter your inTime");
	  String inTime = sc.next();
          boolean b = false;
	  for(Patient p: record){
	   if(p.name.equals(pname)){
	     p.inTime = intTime;
	     b=true;
	     break;
	   }
	  }
          if(!b){
	    System.out.println("You are a new user");
	    Patient p = new Patient(pname, inTime);
	  }
           
	   
	   
	}
}

class Patient{
  
  static int id = 0;
  int p_id;
  String name;
  String inTime;
  String outTime;

        public Patient(String name, String inTime){
	  this.name = name;
	  this.inTime = intTime;
	  this.p_id = ++id;
	}
}
