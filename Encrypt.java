import java.util.*;
public class Encrypt{

	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	int x = sc.nextInt();
	
	   String  res  = "";
	  for(int i=0;i<s.length();i++){
	    if(i%2==0){	 
	      if(s.charAt(i)+x >= 'a' && s.charAt(i)+x <= 'z'){
		res = res + (char)(s.charAt(i)+x);
	      }else if (s.charAt(i)+x > 'z' ){
	        res = res + (char)(s.charAt(i)-26+x);
	      }
	   }else{
	      if(s.charAt(i)-x >= 'a' && s.charAt(i)-x <= 'z'){
		res = res + (char)(s.charAt(i)-x);
	      }else if (s.charAt(i)-x < 'a' ){
	        res = res + (char)(s.charAt(i)+25-x);
	      }
	   }
	}
	System.out.println(res);	

	}
}