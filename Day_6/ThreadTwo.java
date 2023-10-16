class TwoThread extends Thread{
  
    public TwoThread(String name){
      super(name);
    }

    public void run(){
      System.out.println(getName() + "is running");
      
      
    }
     
   

}

public class ThreadTwo {

   public static void main(String[] args){

    TwoThread t1 = new TwoThread("Thread1");
    TwoThread t2 = new TwoThread("Thread2");
    
    t1.start();
    t2.start();
    

    System.out.println("is Thread1 alive" + t1.isAlive());
    System.out.println("is Thread2 alive" + t2.isAlive());
   
   
   } 
}