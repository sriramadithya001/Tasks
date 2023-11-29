import java.util.*;

public class FindTarget{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] a = new int[n];
	for(int i=0;i<n;i++) a[i] = sc.nextInt(); 
	int target = sc.nextInt(); int sum = 0; int from = 0;
	for(int i=0;i<n;i++){
	    if(sum<target) sum+=a[i];
	    if(sum == target) {System.out.println(from + " " + (i-1));break;}
	    if(sum>target) while(sum>target) sum-=a[from++];
        }
    }
}