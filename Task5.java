import java.util.*;


public class Task5{
	
		
		public static void main(String[] args){
		
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			
			String s = Integer.toHexString(n);
			
			System.out.prinltn(s);
			
			HashMap<Integer, Character> h = new HashMap<>();
			
			char digit = '0';
			char c= 'a';
			
			for(int i=0;i<=15;i++){
				if(i<10){
					h.put(i, digit);
					digit++;
				}else{
					h.put(i, c);
					c++;
				}
			}
			String res = ""; 
			if(n==0){
				System.out.println("0");
				
			}else if(n>0){
				while(n!=0){
					res = h.get(n%16) + res;
					n=n/16;

				}
			}else{
				long num = n & 0xffffffffL;
				while(n>0){
					res = h.get(num%16) + res;
					n=n/16;
				}
			}
			
			System.out.println(res);
		}

}