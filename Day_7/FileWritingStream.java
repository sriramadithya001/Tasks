import java.io.FileOutputStream;
public class FileWritingStream {

  public static void main(String[] args){

   String path = "C:\\Users\\Administrator\\Desktop\\Day_7\\output.txt";
   try{
   FileOutputStream f = new  FileOutputStream(path);
   
   String s = "Think but don't overthink";
   byte[] b = s.getBytes();

   f.write(b); 
   }catch(Exception e){

    System.out.println(e);
   }
   
  }
}