class StringThread extends Thread {

   public StringThread(String name){
   super(name);
   }
   String[] s = {"java", "is", "hot", "aromatic", "and", "invigorating"};
   public void run(){
     for(int i=0;i<s.length;i++){
      System.out.println(getName() + " " + s[i]);

      try{
       Thread.sleep(1000);
      }catch(InterruptedException e){
       System.out.println(e);
      }
     }
     
   } 
}

public class Task5 {

   public static void main(String[] args){

   StringThread t1 = new StringThread("Thread1");
   StringThread t2 = new StringThread("Thread2");

   t1.start();
   t2.start();

   }
}