import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex1{

   public static void main(String[] args){
    
     String s = "Na1";
     String regex = "[A-Za-z0-9]*";

     Pattern p = Pattern.compile(regex);
    
     Matcher m = p.matcher(s);

     if(m.matches()){
       System.out.println("Yes matches");
     }else{
       System.out.println("Doesn't matches");
     }

   }
}