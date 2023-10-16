class ThreadStarting implements Runnable{

   public void run(){
   try{
    Thread.sleep(10000);
   }catch(InterruptedException e){
     System.out.println(e);
   }
    System.out.println("Thread has started");
   }
}

public class ThreadCreating {

   public static void main(String[] args){ 
    Thread t = new Thread(new ThreadStarting());
    t.start();
   }
}