import java.util.Scanner;
import java.util.ArrayList;

public class BracketString {

    static boolean isChar(char c) {
	return 'A' <= c && c <= 'Z';
    }

    static void f(int i, int l, int n, String s, ArrayList<Character> ds) {
	if(i==n) {
	    boolean bal = true;int cnt = 0;
	    if(ds.size()<=2) return;
	    if(ds.get(0) !='{' || ds.get(ds.size()-1) !='}') bal = false;
	    for(int j=1;j<ds.size()-1;j++) {
		if(ds.get(j)=='{' && ds.get(j-1)=='}' && isChar(ds.get(j+1))) continue;
		if(ds.get(j)=='}' && isChar(ds.get(j-1)) && ds.get(j+1)=='{') continue;
		if(isChar(ds.get(j))) {cnt++;continue;}
		bal = false;
	    }
	    if(cnt!=l) bal = false;
	    String ans = "";
	    for(int j=0;j<ds.size();j++) ans += ds.get(j);
	    if(bal) System.out.println(ans);
	    return;
	}
	
	ds.add(s.charAt(i));
	f(i+1,l,n,s,ds);
	ds.remove(ds.size()-1);
	f(i+1,l,n,s,ds);
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str = sc.next(), s = "}{";
	for(int i=0;i<str.length();i++) s = s + str.charAt(i) + "}{";
	ArrayList<Character> ds = new ArrayList<>();
	f(0,str.length(), s.length(),s,ds);
    }
}