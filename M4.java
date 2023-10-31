import java.util.*;
public class M4{

	public static void bfs(int r, int c, boolean[][] vis, int[][] ct){
	   vis[r][c] = true;
	   Queue<Index> q = new LinkedList<>();
	   q.add(new Index(r,c));
	   int n = ct.length;
	   int m  = ct[0].length;
	   while(!q.isEmpty()){	 
	      Index id = q.poll();
	      int row  = id.row;
		int col = id.col;
		
		for(int delrow = -1;delrow<=1;delrow++){
		  for(int delcol = -1;delcol<=1;delcol++){
			int nrow = row + delrow;
			int ncol = col + delcol;
	
			if(nrow>=0 && nrow < n && ncol>=0 && ncol < m && ct[nrow][ncol] == 1 && !vis[nrow][ncol] ){
				vis[nrow][ncol ] = true;
				q.add(new Index(nrow, ncol));
			}
		  }
		}
	   }
	}

	public static void main(String[] args){
	
	 Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int m  = sc.nextInt();
	   int[][] ct  = new int[n][m];
	   
	   for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
		   ct[i][j] = sc.nextInt();
	           
		}
	   }
	 
	 boolean[][] vis = new boolean[n][m];
 	 int count=0;
	 
	 for(int i=0;i<n;i++){
	   for(int j=0;j<m;j++){
	      if(!vis[i][j] && ct[i][j] == 1){
	         count++;
	         bfs(i, j, vis, ct);
	      }
	   }
	 }

	System.out.println(count);
	 
	 
	 
    }
}

class Index{

int row;
int col;

	public Index(int row, int col){
	  this.row = row;
	  this.col = col;
	}
}