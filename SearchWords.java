import java.util.Scanner;
import java.util.ArrayList;

public class SearchWords {

    static int n,m,q;
    static char[][] grid = new char[100][100];
    static String[] words = new String[100];
    static boolean[][] vis = new boolean[100][100];
    static int[] row = { -1, -1, -1, 0, 0, 1, 1, 1};
    static int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean f(int r,int c,String word,int i) {
	if(i==word.length()) return true;
	if(r<0 || c<0 || r>=n || c>=m || grid[r][c]!=word.charAt(i) || vis[r][c] == true) return false;

	vis[r][c] = true;
	boolean ans = false;
	for(int k=0;k<8;k++) ans |= f(r+row[k],c+col[k],word,i+1);
	vis[r][c] = false;
	return ans;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();m = sc.nextInt();
	for(int i=0;i<n;i++) for(int j=0;j<m;j++) grid[i][j] = sc.next().charAt(0);
	q = sc.nextInt();
	for(int i=0;i<q;i++) words[i] = sc.next();
	ArrayList<String> valid = new ArrayList<>();
	for(int i=0;i<q;i++) {
	    boolean has = false;
	    for(int r=0;r<n;r++) {
		for(int c=0;c<m;c++) {
	    	    has |= f(r,c,words[i],0);
		}
	    }
	    if(has) valid.add(words[i]);
	    for(int h=0;h<n;h++) for(int w=0;w<m;w++) vis[h][w] = false;
	}
	System.out.println(valid);
    }
}