import java.util.Scanner;
import java.lang.Math;

public class CompareNum {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	float n = sc.nextFloat();

	if(n==0) System.out.print("zero small");
	else {
	    System.out.print("positive or negative");
	    if(Math.abs(n-0) > 1000000) System.out.print(" large");
	}
	
    }
}