import java.util.Scanner;
import java.util.HashMap;

public class SpecialStringGroup {

    static String sort(char[] words) {
	int n = words.length;
	for(int i=0;i<n;i+=2) {
	    for(int j=i+2;j<n;j+=2) {
		if(words[i] > words[j]) {
		    char temp = words[i];
		    words[i] = words[j];
		    words[j] = temp;
		}
	    }
	}

	for(int i=1;i<n;i+=2) {
	    for(int j=i+2;j<n;j+=2) {
		if(words[i] > words[j]) {
		    char temp = words[i];
		    words[i] = words[j];
		    words[j] = temp;
		}
	    }
	}
	String nw = "";
	for(int i=0;i<n;i++) nw += words[i];
	return nw;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();String[] words = new String[n];
	for(int i=0;i<n;i++) words[i] = sc.next();
	for(int i=0;i<n;i++) words[i] = sort(words[i].toCharArray());
	int cnt = 0;
	HashMap<String,Integer> mp = new HashMap<>();
	for(int i=0;i<n;i++) mp.put(words[i],1);
	System.out.println(mp.size());
    }
}