import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class WriteUpperCase {

  public static void main(String[] args){
   
   Scanner sc = new Scanner(System.in);
   String path = "C:\\Users\\Administrator\\Desktop\\Day_7\\uppercase.txt";
   File f = new File(path);
   try{
   f.createNewFile();
   FileWriter writer = new FileWriter(f);
   
   String s;
   while(true){
     s = sc.nextLine();

    if(s.equalsIgnoreCase("exit")){
     break;
    }

    writer.write(s.toUpperCase());
   }
     writer.close();
    }catch(Exception e){
     System.out.println(e);
    }finally{
     sc.close();
    
    }
 
  }
}