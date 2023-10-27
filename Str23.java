import java.util.*;

public class Str23{

    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();	
	int y = sc.nextInt();
        int[][] n = new int[x][y];
	for(int i=0;i<x;i++){
	  for(int j=0;j<y;j++){
	    n[i][j] = sc.nextInt();
	  }
	}
	System.out.println("Enter the Hits");
	int x1 = sc.nextInt();
        int[][] h = new int[x1][2];
	for(int i=0;i<x1;i++){
	  for(int j=0;j<2;j++){
	    h[i][j] = sc.nextInt();
	  }
	}
        for(int l=0;l<x1;l++){
          int z1 = h[l][0];
	  int z2 = h[l][1];
          n[z1][z2] = 0;
        Queue<Grid> q = new LinkedList<>();
	 
        int r=0;
        for(int c=0;c<y;c++){
        if(n[r][c] == 1){
	  q.add(new Grid(r,c));
	 }
	}

	while(q.size()>0){
	  Grid g = q.poll();
	  n[g.row][g.col] = 0;
          if(g.row<x1){
          if(n[g.row+1][g.col]==1){
	    q.add(new Grid(g.row+1, g.col));
	  }
	  }
          
	}
	int count =0;
	for(int i=0;i<x;i++){
	  for(int j=0;j<y;j++){
	   if( n[i][j] == 1){
	    count++;
		}
	  }
	}
        System.out.println(count);
	}

    }
}

class Grid{
   int row;
   int col;
	public Grid(int row, int col){
	 this.row = row;
	 this.col = col;
	}
}