import java.util.Scanner;

public class StoreKeeperGame {
    static char[][] grid = new char[100][100];
    static int n,m;
    static boolean[][] vis = new boolean[100][100];
    static boolean[][] vis2 = new boolean[100][100];
    static int p_row = -1,p_col = -1,b_row = -1,b_col = -1,t_row = -1,t_col = -1;


    public static boolean f(int p_row,int p_col,int b_row,int b_col,int h_row,int h_col) {
	if(p_row==h_row && p_col==h_col) return true;
	if(p_row<0 || p_col<0 || p_row>n-1 || p_col>m-1 || grid[p_row][p_col]=='#' || grid[p_row][p_col]=='B' || vis2[p_row][p_col]==true) return false;

	vis2[p_row][p_col] = true;

	boolean reach = f(p_row-1,p_col,b_row,b_col,h_row,h_col) || f(p_row+1,p_col,b_row,b_col,h_row,h_col) || f(p_row,p_col-1,b_row,b_col,h_row,h_col) || f(p_row,p_col+1,b_row,b_col,h_row,h_col);

	vis2[p_row][p_col] = false;

	return reach;
    }


    public static int fun(int b_row,int b_col,int t_row,int t_col, int moves) {
	if(b_row==t_row && b_col==t_col) return moves;
	if(b_row<0 || b_col<0 || b_row>n-1 || b_col>m-1 || grid[p_row][p_col]=='#' || vis[b_row][b_col]==true) return 10000;

	vis[b_row][b_col] = true;

	int[] d = new int[4];
	for(int i=0;i<4;i++) d[i] = 10000;
	
	if(f(p_row,p_col,b_row,b_col,b_row+1,b_col)) {p_row=b_row+1;p_col=b_col;d[0] = fun(b_row-1,b_col,t_row,t_col,moves+1);}
	if(f(p_row,p_col,b_row,b_col,b_row-1,b_col)) {p_row=b_row-1;p_col=b_col;d[1] = fun(b_row+1,b_col,t_row,t_col,moves+1);}
	if(f(p_row,p_col,b_row,b_col,b_row,b_col+1)) {p_row=b_row;p_col=b_col+1;d[2] = fun(b_row,b_col-1,t_row,t_col,moves+1);}
	if(f(p_row,p_col,b_row,b_col,b_row,b_col-1)) {p_row=b_row;p_col=b_col-1;d[3] = fun(b_row,b_col+1,t_row,t_col,moves+1);}

	vis[b_row][b_col] = false;

	int mnMoves = 10000;
	for(int i=0;i<4;i++) d[i] = Math.min(mnMoves, d[i]);
	return mnMoves;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();m = sc.nextInt();
	for(int i=0;i<n;i++) for(int j=0;j<m;j++) {
	    grid[i][j] = sc.next().charAt(0);
	    if(grid[i][j] == 'S') {p_row = i;p_col = j;}
	    else if(grid[i][j] == 'B') {b_row = i;b_col = j;}
	    else if(grid[i][j] == 'T') {t_row = i;t_col = j;}
	}

	int cnt = fun(b_row,b_col,t_row,t_col,0);
	System.out.println(cnt==10000 ? -1 : cnt);
    }
}


























































/*
# # # # # #
# T # # # #
# . . B . #
# . # # . #
# . . . S #
# # # # # #*/