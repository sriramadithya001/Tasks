import java.util.Scanner;

public class TrianglePattern {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();int n = s.length(), m = n/2;
	for(int i=0;i<=m;i++) {
	    for(int j=0;j<n;j++) System.out.print(j==m+i || j==m-i ? s.charAt(j) : ' ');
	    System.out.println();
	}

	for(int i=m;i>=0;i--) {
	    for(int j=0;j<n;j++) System.out.print(j==m+i || j==m-i ? s.charAt(j) : ' ');
	    System.out.println();
	}
    }
}