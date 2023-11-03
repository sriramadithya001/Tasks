import java.util.*;
public class Sort{

 	public static void main(String[] args){
	
	  //Scanner sc = new Scanner(System.in);
	  
	   String s = "cedBAfIGa";
	   char[] c = s.toCharArray();
	   Arrays.sort(c);

	   System.out.println(Arrays.toString(c));
           boolean b[] = new boolean[c.length];
	   ArrayList<Character> up = new ArrayList<>();
	   ArrayList<Character> lc = new ArrayList<>();
	  
	   for(int i=0;i<c.length;i++){
	     if(s.charAt(i)>='a' && s.charAt(i)<='z'){
	       b[i] = true;
	     }
	   }
	   for(int i=0;i<c.length;i++){
	     if(c[i]>='a' && c[i]<='z'){
		lc.add(c[i]);
	     }else{
		up.add(c[i]);
	     }
	   }

	  String res = "";
	  System.out.println(lc);
	  System.out.println(up);
	  int u = 0; int l =0 ;
	  for(int i=0;i<b.length;i++){	
		if(b[i]){
		  res  = res + lc.get(l);
		  l++;
		}else{
		  res = res + up.get(u);
		  u++;
		}

	  }
		System.out.println(res);
	   
	}
}