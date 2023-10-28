import java.util.*;

public class Hospital{
           static double Doctor = 9;
	   static M_P1 = 8;
	   static M_p2 = 8;
       
	public static void meet1(Patient p){
           double ot  = p.inTime;
	   double wait = p.wait;
	   if(ot>=M_P1){
	     M_P1 = ot + 5.00;
	     ot = ot + 5.00;
	   }else{
             wait = MP_1 - ot;
	     MP_1+=5.00;
	     ot = MP_1;
	   }
           p.outTime = ot;
	   p.wait = wait;
           
	}
        public static void meet2(Patient p){	
	  double ot  = p.outTime;
	   double wait = p.wait;
	   if(ot>=M_P2){
	     M_P1 = ot + 5.00;
	     ot = ot + 5.00;
	   }else{
             wait = MP_2 - ot;
	     MP_2+=5.00;
	     ot = MP_2;
	   }
           p.outTime = ot;
	   p.wait = wait;
        }
	public static void meetDoctor(Patient p){
         Random r = new Random();
	 int doctime = random.nextInt(19) + 2;
	 double ot  = p.outTime;
	   double wait = p.wait;
	   if(ot>=Doctor){
	     Doctor = ot + doctime ;
	     ot = Dcotor;
	   }else{
             wait = Doctor - ot;
	     Doctor+=doctime;
	     ot = Doctor;
	   }
           p.outTime = ot;
	   p.wait = wait;
	}
	 
        public static void getMedicine(Patient p ){
	   p.outTime+=5.00;
           
	}
       
        public static void printDetails(ArrayList<Patient> list ){
	  
	}
	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
          ArrayList<Patient> record = new ArrayList<>();
	  while(true){
          System.out.println("1. To continue\n "+ "2.print management details\n"+"0. To exit");
	  int inp = sc.nextInt();
	  if(inp==1){
	  System.out.println("Hey..Welcome to L3 Hospital");
	  System.out.println("Enter patient name");
	  String pname = sc.next();
	  System.out.println("Enter your inTime");
	  double inTime = sc.nextDouble();
          boolean b = false;
	  Patient p1 = new Patient();
	  for(Patient p: record){
	   if(p.name.equals(pname)){
	     p.inTime = intTime;
	     p1 = p;
	     b=true;
	     break;
	   }
	  }
          if(!b){
	    System.out.println("You are a new user");
	    p1.name = pname;
	    p1.inTime = inTime;
	  }
   	  
	  int wait = 0;
          
          System.out.println("Now you can meet medical professional 1");
	  meet1(p1);
	  meet2(p1);
          meetDoctor(p1);
	  getMedicine(p1);
	  record.add(p1);
	  System.out.println("You can now leave..Get well soon...Thanks");
	}else if(inp == 2){
          printDetails(record);
        }
	else if(inp == 0){
         break;
        }
			
	  }
	   
	}
}

class Patient{
  
  static int id = 0;
  int p_id;
  String name;
  double inTime;
  double outTime;
  int wait;

        public Patient(String name, double inTime){
	  this.name = name;
	  this.inTime = intTime;
	  this.p_id = ++id;
	  this.wait = 0;
	}

	public Patient(){}
}
