
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex7{

   public static void main(String[] args){
    
       String s = "100.01.02.100";
       String regex = "\\b0+|(?<=\\.)0+";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(s);
       String s1 = m.replaceAll("");
       System.out.println(s1);

       

    }
}