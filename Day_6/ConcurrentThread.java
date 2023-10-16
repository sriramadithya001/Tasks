class ChildThread extends Thread{

    public ChildThread(String name){
      super(name);
      System.out.println("ChildThread created" + getName());
    //  this.start();
    }

    public void run(){ 
      for(int i=0;i<5;i++){
        System.out.println(getName() + " count" + i);
        try{
         Thread.sleep(1000);
        }catch(InterruptedException e){
         System.out.println(e);
        }
      }
    }

} 

public class ConcurrentThread{

  public static void main(String[] args){
   
     ChildThread c = new ChildThread("ChildThread");
     c.start();
     System.out.println(c.getPriority());
     
     Thread mainThread = Thread.currentThread();
     System.out.println(mainThread.getPriority());     
 
     for(int i=0;i<5;i++){
       System.out.println("Main Thread count " + i);
        try{
         Thread.sleep(1000);
        }catch(InterruptedException e){
         System.out.println(e);
        }
     }

  }
}