import java.util.Scanner;

public class ExcelColumnNumber {
	public static int findColumnNumber(String s) {
		if(s.length()==0) {
			return 0;
		}
		int res = 0;
		for(int i=0;i<s.length();i++) {
		    int val = s.charAt(i)-'A'+ 1;
		    res=res*26+charvalue;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(findColumnNumber(s));
	}
}