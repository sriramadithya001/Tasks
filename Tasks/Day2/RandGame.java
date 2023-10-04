import java.util.Scanner;
import java.util.Random;

public class RandGame {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int n1 = random.nextInt(10000);
        while(true) {
            int n2 = sc.nextInt();
            if(n1 == n2) {
                System.out.print("You find it"); 
                break;
            }
            else if(n1<n2) System.out.println("High");
            else System.out.println("Low");
        }
    }
}
