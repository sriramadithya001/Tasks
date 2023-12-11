import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt(),x=n;
	for(int i=1;i<2*n;i++) {
	    for(int j=1;j<2*n;j++) {
	        System.out.print(x + " ");
	        if(i>j) x--;
		if(j!=2*n-1 && i+j>=2*n) x++;
	    }
	    System.out.println();
	}
    }
}