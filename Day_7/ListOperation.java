import java.util.*;

public class ListOperation{

   public static void main(String[] args){

    List<Integer> list = new ArrayList<>(Arrays.asList(3,1,2,5,7,4,9));

    //Collections.sort(list, (a,b)->a-b);//ascending order

   // Collections.sort(list, (a,b)->b-a);//decending order
   // System.out.println(list);

  //  Collections.reverse(list);

    int i=0; int j=list.size()-1;
    while(i<=j){

      Collections.swap(list, i,j);
      i++; 
      j--;

    }
    System.out.println(list);
   
    }
}