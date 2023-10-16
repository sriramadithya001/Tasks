
import java.io.File;
public class FileRename{

   public static void main(String[] args){

     if(args.length != 1){
       System.out.println("Please give the name of file to rename");
       return;
     }


    String old_name = args[0];
    String new_name = "renamed_"+old_name;
    String file1 = "C:\\Users\\Administrator\\Desktop\\Day_7\\" + old_name;
    String file2 = "C:\\Users\\Administrator\\Desktop\\Day_7\\" + new_name;
    File oldFile = new File(file1);

    File newFile = new File(file2);

    if(oldFile.renameTo(newFile)){
     System.out.println(oldFile.getName() + "   " + newFile.getName());

      if(newFile.delete()){ 
        SYstem.out.println("File deleted successfully");
      }else{
        System.out.println("Error occured while deleting the file");
      }
 
    }else{
     System.out.println("Failed to rename the file");
    }

   }
}