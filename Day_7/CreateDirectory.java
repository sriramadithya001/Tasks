import java.io.File;
public class CreateDirectory{

  public static void main(String[] args){

   String path = "C:\\Users\\Administrator\\Desktop\\Day_8";
   File f = new File(path);
   try{
   f.mkdir();
   if(f.exists()){
    System.out.println("Directory successfully created");
   }
   }catch(Exception e){
     System.out.println(e);
   }

  }
}