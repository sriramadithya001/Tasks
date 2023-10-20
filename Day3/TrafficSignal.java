import java.util.*;
public class TrafficSignal{
    
	public static void main(String[] args){
  	Scanner sc = new Scanner(System.in);
        
        Yellow y = new Yellow("YellowThread");
        
        Green g = new Green("GreenThread");
        System.out.println("Hey press any key to turn off the signal!");
        while(true){
       /* try{
        if(System.in.available()>0){
	 System.out.println("Turning off the signal...");
	 break;
        }
	}catch(Exception e){
	 System.out.println(e);
	}*/
    	System.out.println("RED     ----STOP!-----");
        try{
        Thread.sleep(1000);
	}catch(Exception e){
	 System.out.println(e);
	}
        y.start();
        try{
        Thread.sleep(1000);
	}catch(Exception e){
	 System.out.println(e);
	}
	try{
        if(y.isAlive()){
        y.join();
        }
        }catch(Exception e){System.out.println(e);}
	
	g.start();
        try{
        Thread.sleep(1000);
	}catch(Exception e){
	 System.out.println(e);
	}
	try{
	if(g.isAlive()){
        g.join();}}catch(Exception e){System.out.println(e);}
        }
  
	}
}

class Yellow extends Thread {

     public Yellow(String name){
	super(name);
     }

     public void run(){
        try{
        Thread.sleep(1000);
	}catch(Exception e){
	 System.out.println(e);
	}
        System.out.println("YELLOW    -----Listen!-----");
     }

}

class Green extends Thread {

public Green(String name){
	super(name);
     }

     public void run(){
	try{
        Thread.sleep(1000);
	}catch(Exception e){
	System.out.println(e);
	}	
        System.out.println("GREEN    -----Go!-----");
     }

}