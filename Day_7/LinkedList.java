public class LinkedList{

   
   static class Node{

    int data;
    Node next;
      
       Node(int d){
       data = d;
       next = null;
      }
   }

   Node Head = null;

   public void insert(int data){
    Node new_node = new Node(data);
    if(Head == null){
     Head = new_node;
    }else{
     Node last = Head;
     while(last.next!=null){
       last = last.next;
     }
     last.next = new_node;
    }
   }

   public void search(int data){
     Node last  = Head;
     boolean b = false;
     while(last != null){
       
       if(last.data == data){
         System.out.println("Element is prensent in the list");
         b=true;
       }
       last = last.next;
     }
     if(!b){
     System.out.println("Element not present in the list");}
   }

   
   public void update(int index, int data){
      Node last = Head;
      int i=0;
      while(i<index){
       last = last.next;
      }
      last.data = data;
    
   }
   
   public void delete(int index){
   
      Node tmep = Head;
      Node prev = null;

      for(int i=0;i<index;i++){
        prev = temp;
        temp = temp.next;
      }
      prev.next = temp.next;

   }

   public static void main(String[] args){

	LinkedList list = new LinkedList();
        list.insert(1);
	list.insert(2);
	list.insert(3);
	list.insert(4);
	list.insert(5);
	list.search(1);
       
        
   }
}