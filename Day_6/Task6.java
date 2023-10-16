class StringThread implements Runnable{
   private String ThreadName;

   public StringThread(String ThreadName){
   this.ThreadName = ThreadName;
   }

   String[] s = {"java", "is", "hot", "aromatic", "and", "invigorating"};

   public void run(){
     for(int i=0;i<s.length;i++){
      System.out.println(this.ThreadName + " " + s[i]);

      try{
       Thread.sleep(1000);
      }catch(InterruptedException e){
       System.out.println(e);
      }
     }
     
   } 
}

public class Task6 {

   public static void main(String[] args){

   StringThread r1 = new StringThread("Thread1");
   StringThread r2 = new StringThread("Thread2");
  
   Thread t1 = new Thread(r1);
   Thread t2 = new Thread(r2);

   t1.start();
   t2.start();

   }
}