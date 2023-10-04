import java.util.Scanner;

public class OddNumSum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        
        System.out.println("The odd numbers are : ");
        for(int i=1;i<n*2;i+=2) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("Sum of first " + n  + " odd terms : " + sum);
    }
}