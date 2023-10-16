import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex2{

   public static void main(String[] args){
    
     String s = "[pP][qQ]*";
     String regex = "pq*";

     Pattern p = Pattern.compile(regex);
    
     Matcher m = p.matcher(s);

     if(m.matches()){
       System.out.println("Yes matches");
     }else{
       System.out.println("Doesn't matches");
     }

   }
}