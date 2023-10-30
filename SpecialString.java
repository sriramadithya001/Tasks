import java.util.Scanner;

public class SpecialString {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();int n = s.length(), sp = 0;
	for(int i=0;i<n;i++) {
	    for(int j=i;j<n;j++) {
		boolean[] cnt = new boolean[26];
		for(int k=i;k<=j;k++) cnt[s.charAt(k) - 'a'] = true;
		int count = 0;
		for(int k=0;k<26;k++) count += (cnt[k] ? 1 : 0);
		if(count == 1) sp++;
		else if(count ==2 && (j-i+1)%2==1 && cnt[s.charAt(j-i+1)-'a']==1) sp++;
	    }
	}
	System.out.println(sp);
    }
}
