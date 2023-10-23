import java.util.*;
import java.io.File;
import java.io.IOException;
public class Telephone{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long start=0, end=011;
        boolean b = false;
        while(true){
        System.out.println("1. Connect call\n" + "2. Disconnect call");
        
        int n = sc.nextInt();
        if(n==2 && !b){
          System.out.println("No call is in active..press 1 to connect call");
        }else if(n==1){
          b=true;
          System.out.println("Call connected");
           start = System.currentTimeMillis();
        }else if(n==2 && b){
            end = System.currentTimeMillis();
            System.out.println("Call disconnected");
            System.out.println("Time duration: " + (end-start));
        }else if(n==0){
            break;
        }
    }
        
    }
}