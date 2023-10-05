import java.util.Scanner;

public class CompareNum {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	float n = sc.nextFloat();

	if(n==0) System.out.print("zero");
	else {
	    if(n>0) System.out.print("positive");
	    else if(n<0) System.out.print("negative");

	    if(Math.abs(n-0) > 1000000) System.out.print(" large");
	    else if(Math.abs(n-0) < 1) System.out.print(" small");
	}
	
    }
}