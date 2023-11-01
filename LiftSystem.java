import java.util.*;
public class LiftSystem{



	public static void displayLifts(ArrayList<Lift> Lifts){
	  for(Lift l: Lifts){
	    if(l.mtnc==-1){	
	     continue;
	    }
	    System.out.println(l.name + "  " + l.floor);
	  }
	}
	public static void marktheliftasMaintanance(ArrayList<Lift> Lifts){
	   String name = "";
	   System.out.println("Enter the lift name");
	   String s  = new Scanner(System.in).next();
	   for(Lift l : Lifts){
	     if(l.name.equals(s)){
	       l.mtnc = -1;
	       name = l.name;
	     }
	   }
	   System.out.println("Lift "+ name + " is under Maintanance");
	   
	}
	public static Lift getLessStops(ArrayList<Lift> lifts, ArrayList<Lift> gen, int c, int d){
	   Lift last = null;
           if(c<=5 && d<=5){
	     for(Lift l: lifts){
	       if(l.name.equals("L1") || l.name.equals("L2")){
	         last = l;
	         break; 
	       }
	     }
	     if(last==null){
	      for(Lift l: gen){
	       if(l.name.equals("L1") || l.name.equals("L2")){
	         last = l;
	         break; 
	       }
	     } 
	     }
	   }else if(c>5 && d>5){
	     for(Lift l: lifts){
	       if(l.name.equals("L2") || l.name.equals("L3")){
	         last = l;
	         break; 
	       }
	     }
	     if(last==null){
	      for(Lift l: gen){
	       if(l.name.equals("L2") || l.name.equals("L3")){
	         last = l;
	         break; 
	       }
	     } 
	     }

	   }else if(last == null){
	    last = lifts.get(0);
	   }
	   if(last==null){
	     System.out.println("No lift");
	   }
	   System.out.println(lifts);
	   return last;
	}
	public static ArrayList<Lift> getSameDirected(ArrayList<Lift> same, int c, int d){
             for(Lift l: same){
	     if((l.floor>c && l.floor<d) || (l.floor<c && l.floor>d)){
	        same.remove(l);
	     }
	   }
	   return same;
	}
	public static ArrayList<Lift> getNearest(ArrayList<Lift> lifts, int c){
	    ArrayList<Lift> near = new ArrayList<>();
	    int min  = 100;
	    for(Lift l: lifts){
	      if(Math.abs(l.floor - c)< min){	 
	          min  = Math.abs(l.floor - c);
	      }
	    }
	    for(Lift l: lifts){
	      if(Math.abs(l.floor - c)==min  && l.mtnc!=-1){	 
	          near.add(l);
	      }
	    }
	    return near;
	    
	}

	public static void assignLift(ArrayList<Lift> Lifts){
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter your current floor");
	   int current  = sc.nextInt();
	   System.out.println("Enter your destination floor");
	   int desti = sc.nextInt();
	   ArrayList<Lift> near = getNearest(Lifts, current);
	   ArrayList<Lift> samedirect = getSameDirected(near, current, desti);
	   System.out.println(samedirect);
	   Lift l = getLessStops(samedirect, Lifts, current, desti);
	   l.floor = desti;
   	   System.out.println("Lift  "+ l.name + "  is assigned");
	}
	static ArrayList<Lift> Lifts = new ArrayList<>();
	
 	public static void main(String[] args){

	Lifts.add(new Lift("L1",0, 5));
	Lifts.add(new Lift("L2",0, 5));
	Lifts.add(new Lift("L3",0, 10));
   	Lifts.add(new Lift("L4",0, 10));
	Lifts.add(new Lift("L5",0, 10));

	Scanner sc = new Scanner(System.in);
	
	boolean b = false;
	while(true){
	System.out.println("Select the option");
	System.out.println("1. DisplayLifts\n" + "2.AsssignLif\n" + "3.mark the lift as maintanance");
	int n = sc.nextInt();
	if(n==1){
	  displayLifts(Lifts);
	}else if(n==2){
	  assignLift(Lifts);
	}else if(n==0){
	  break;
	}else if(n==3){
	 marktheliftasMaintanance(Lifts);
	}
	}

	}
}

class Lift{
String name;
int floor;
int stop;
int mtnc = 0;

	public Lift(String name, int floor, int stop){
	 this.name = name;
	 this.floor = floor;
	 this.stop = stop;
	 
	}

	public Lift(){
	}
}