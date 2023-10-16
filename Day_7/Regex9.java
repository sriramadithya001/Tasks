
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex9{

   public static void main(String[] args){
    
       String s = "Nieethish";
       String regex = "[aeiou]";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(s);
       String s1 = m.replaceAll("");
       System.out.println(s1);

       

    }
}