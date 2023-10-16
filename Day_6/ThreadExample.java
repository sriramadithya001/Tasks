class MyThread extends Thread {
    public MyThread(String threadName) {
        super(threadName); // Call the base class (Thread) constructor with the thread name
        System.out.println("Child thread created: " + getName());
        start(); // Start the thread
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread childThread = new MyThread("ChildThread");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Main Thread interrupted.");
            }
        }
    }
}
