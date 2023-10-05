import java.util.Scanner;

public class AddBinaryNumbers {
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	String b1  = sc.next(), b2 = sc.next();

	int i=b1.length()-1, j=b2.length()-1, carry = 0;
	String ans = "";
	while(i>=0 && j>=0) {
	      if(b1.charAt(i)=='0' && b2.charAt(j)=='0') {
		   if(carry == 0) {
			ans = '0' + ans;
		   }
		   else {
			ans = '1' + ans;
		   }
		   carry = 0;
	      }
	      else if((b1.charAt(i)=='0' &&  b2.charAt(j)=='1') || (b1.charAt(i)=='1' &&  b2.charAt(j)=='0')) {
		   if(carry == 0) {
			ans = '1' + ans;
		   }
		   else {
			ans = '0' + ans;
			carry = 1;
		   }
	      }
              else {
		  if(carry == 0) {
			ans = '0' + ans;
		   }
		   else {
			ans = '1' + ans;
		   }
	           carry = 1;
	      }
	      i--;j--;
	 }
	 while(i>=0) ans = b1.charAt(i--) + ans;
	 while(j>=0) ans = b2.charAt(j--) + ans;
	 if(carry == 1) System.out.print(1);
	 System.out.print(ans);
    }
}