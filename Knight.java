import java.util.Scanner;

public class Knight {

    static char[][] board = new char[100][100];
    static boolean[][] vis = new boolean[100][100];
    static int N;

    public static int f(int k_row, int k_col, int t_row, int t_col, int moves) {

	if(k_row==t_row && k_col==t_col) {
	    return moves;
	}

	if(k_row<0 || k_col<0 || k_row>N-1 || k_col>N-1 || vis[k_row][k_col]==true) return 1000;

	vis[k_row][k_col] = true;
	int[] arr = new int[8];
	arr[0] = f(k_row-2, k_col-1, t_row,t_col, moves+1);
	arr[1] = f(k_row-2, k_col+1, t_row,t_col, moves+1);
	arr[2] = f(k_row+2, k_col-1, t_row,t_col, moves+1);
	arr[3] = f(k_row+2, k_col+1, t_row,t_col, moves+1);
	arr[4] = f(k_row-1, k_col-2, t_row,t_col, moves+1);
	arr[5] = f(k_row+1, k_col-2, t_row,t_col, moves+1);
	arr[6] = f(k_row-1, k_col+2, t_row,t_col, moves+1);
	arr[7] = f(k_row+1, k_col+2, t_row,t_col, moves+1);
	vis[k_row][k_col] = false;

	int mnMoves = 1000;

	for(int i=0;i<8;i++) mnMoves = Math.min(mnMoves, arr[i]);

	return mnMoves;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	int k_row = sc.nextInt(), k_col = sc.nextInt(), t_row = sc.nextInt(), t_col = sc.nextInt();
	int mn = f(k_row, k_col, t_row, t_col, 0);
	System.out.println(mn);
    }
}