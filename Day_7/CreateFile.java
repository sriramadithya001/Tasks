
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

public class CreateFile{


  public static void main(String[] args){

      File f = new File("C:\\Users\\Administrator\\Desktop\\Day_7\\newFile.txt");

      try{f.createNewFile();
      }catch(IOException e){
      System.out.println(e);
      }

      try{
       Scanner reader = new Scanner(f);

       while(reader.hasNextLine()){
        String data = reader.next();
        System.out.println(data);
       }
       reader.close();
       }catch(Exception e){
        System.out.println(e);
       }
      
       try{
         FileWriter writer = new FileWriter("C:\\Users\\Administrator\\Desktop\\Day_7\\newFile.txt");
         writer.write("But u can have that high confidence stuff to rewite this as false!");
         writer.close();
       }catch(Exception e){System.out.println(e);}

       if(f.exists()){
        System.out.println("sgf");
       }else{
         System.out.println("No..File doesn't exists");
       }

       if(f.isFile()){ System.out.pritnln("yes..this is file");
       }else{ 
         System.out.println("No..its a directory");
       }

       System.out.println("Name of the file is " + f.getName());
       System.out.println("And its path is " + f.getAbsolutePath());
     
    }
}