import java.util.*;

public class VectorClass {

    public static void main(String[] args){

     Vector<Integer> v = new Vector<>();

     for(int i=0;i<6;i++){
	v.add(i);
     }
     
     System.out.println("Capacity of the Vcetor : " + v.capacity());
     System.out.println("Size of the Vector : " + v.size());
     System.out.println("is constains 1 : " + v.contains(1));
     System.out.println("is the vector empty : " + v.isEmpty());

     Iterator it = v.iterator();

     while(it.hasNext()){
      System.out.println(it.next() + "  ");
     }


  
     
     

    }
}