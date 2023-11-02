import java.util.*;

public class Baloon{

	public static void print(char[][] mt){
	   int n = mt.length;
	    for(int i=0;i<n;i++){
	      for(int j=0;j<n;j++){
	        System.out.print(mt[i][j] + " ");
	      }
	   System.out.println();
	 }
	}

	public static void burstRow(char[][] mt){
	    int n = mt.length;
	    for(int i=0;i<n;i++){
	        int count = 0; int idx = 0;
		for(int j=0;j<n-1;j++){
	           
	           if(mt[i][j]==mt[i][j+1]){
		     ++count;
	             if(count==3){
	               idx = j;
	             }
	           }else{
			count=0;
	           }
	        }
	        if(count==3){
	         while(count>0){
	           mt[i][idx] = '-';
		   idx--;
	           count--;
	         }
	        }
	    }
	}

	public static void update(char[][] mt, int col, char cl){
	    int n = mt.length-1;
	     for(int i=n;i>=0;i--){
	       if(mt[i][col] == '-'){
	         mt[i][col] = cl;
	         break;
	       }
	     }
	     burstRow(mt);
	     burstCol(mt);
	}
	public static void burstCol(char[][] mt){
	    int n = mt.length;
	    for(int i=0;i<n;i++){
	        int count = 0; int idx = 0;
		for(int j=0;j<n-1;j++){
	           
	           if(mt[j][i]==mt[j+1][i]){
		     ++count;
	             if(count==3){
	               idx = j;
	             }
	           }else{
			count=0;
	           }
	        }
	        if(count==3){
	         while(count>0){
	           mt[idx][i] = '-';
		   idx--;
	           count--;
	         }
	        }
	    }
	}

	/*public static void update(char[][] mt, int col, char cl){
	    int n = mt.length-1;
	     for(int i=n;i>=0;i--){
	       if(mt[i][col] == '-'){
	         mt[i][col] = cl;
	         break;
	       }
	     }
	     burstRow(mt);
	     burstCol(mt);
	}*/


	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	 System.out.println("Enter the matrix size");
	 int n = sc.nextInt();
	 char[][] mt = new char[n][n];
	 for(int i=0;i<n;i++){
	  for(int j=0;j<n;j++){
	     mt[i][j] = '-';
	   }
	 }
	 while(true){
	   System.out.println("Do you wish to continue say y/n");
	   char c = sc.next().charAt(0);
	   if(c=='y'){
	     System.out.println("Enter the column number");
	     int col = sc.nextInt();
	     System.out.println("Enter the colour of the baloon");
	     char cl = sc.next().charAt(0);
	     print(mt);
	     update(mt, col, cl);
	     print(mt);
	   }else{
	     break;
	   }
	 }
	}	
}