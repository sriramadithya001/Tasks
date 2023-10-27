import java.util.Scanner;
import java.util.ArrayList;

public class EncodeString {
    static String ans = "";
    public static void f(int i,int n,String s,ArrayList<String> partition) {
	if(i == n) {
	    String cur = "", t = partition.get(0);
	    for(int k=0;k<partition.size();k++) {
		int j = k,cnt = 0;
		for(;j<partition.size();j++) {
		    if(partition.get(k).equals(partition.get(j))) cnt++;
		    else break;
		}
		if(cnt==1) cur += partition.get(k);
		else cur = cur + cnt + "[" + partition.get(k) + "]";
		k = j-1;
	    }
	    if(cur.length() < ans.length()) ans = cur;
	    System.out.println(partition);
	}
	
	// created 'n' nested loops
	for(int j=i;j<n;j++) {
	    partition.add(s.substring(i,j+1));
	    f(j+1,n,s,partition);
	    partition.remove(partition.size()-1);
	}
    } 

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();int n = s.length();ans = s;
	ArrayList<String> partition = new ArrayList<>();
	f(0,n,s,partition);
	System.out.print(ans);
    }
}





/*



	if(i == n) {
	    String cur = "", t = partition.get(0);
	    for(int k=0;k<partition.size();k++) {
		int j = k,cnt = 0;
		for(;j<partition.size();j++) {
		    if(partition.get(k).equals(partition.get(j))) cnt++;
		    else break;
		}
		if(cnt==1) cur += partition.get(k);
		else cur = cur + cnt + "[" + partition.get(k) + "]";
		k = j-1;
	    }
	    if(cur.length() < ans.length()) ans = cur;
	}


    public static String addString(String s,int k) {
	if(s.length() > k) {
	    String nw = "";
	    for(int i=0;i<s.length();i+=k) {
	        int sum = 0;
	        for(int j=i;j<Math.min(s.length(),i+k);j++) sum += s.charAt(j) - '0';
	        nw += sum;
	    }  
	    return addString(nw,k);
	}
	return s;
    }

*/