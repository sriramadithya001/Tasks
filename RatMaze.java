import java.util.Scanner;
import java.util.ArrayList;

public class RatMaze {
    

    static int n;
    static boolean[][] maze = new boolean[100][100];
    static boolean[][] vis  = new boolean[100][100];
    static int[] row = {-1 , 1 , 0  , 0};
    static int[] col = {0 , 0  , -1 , 1};

    static void f(int r,int c,ArrayList<ArrayList<Integer>> path) {
	if(r==n-1 && c==n-1) {
	    ArrayList<Integer> cell = new ArrayList<>();
	    cell.add(r);cell.add(c);path.add(cell);
	    System.out.println(path);
	    System.out.println();
	    return;
	}

	if(r<0 || c<0 || r>n-1 || c>n-1 || maze[r][c]==false || vis[r][c]==true) return;

	vis[r][c] = true;

	ArrayList<Integer> cell = new ArrayList<>();
	cell.add(r);cell.add(c);path.add(cell);


	for(int d=0;d<4;d++) f(r+row[d] , c + col[d] , path);

	vis[r][c] = false;

	if(path.size()>0) path.remove(path.size()-1);

    }


    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	for(int i=0;i<n;i++) for(int j=0;j<n;j++) maze[i][j] = (sc.nextInt()==1 ? true : false);
	ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
	f(0,0,path);
    }
}