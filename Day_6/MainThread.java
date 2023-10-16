public class MainThread{

  public static void main(String[] args){

    Thread mainThread = Thread.currentThread();
    System.out.println("Name" + mainThread.getName());
    System.out.println("ID" + mainThread.getId());
    System.out.println("Priority" + mainThread.getPriority());
    System.out.println("isDaemon" + mainThread.isDaemon());
    System.out.println("State" + mainThread.getState());
    

    }
}