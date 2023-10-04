import java.util.Scanner;

public class Power {
    
    public static long pow(int a,int b,int res) {
        if(b==0) return res;
        return pow(a,b-1,res*a);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(pow(a,b,1));
    }
}
