
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex10{

   public static void main(String[] args){
    
       String s = "10.00";
       String regex = "[.]";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(s);
       int n = s.length();
       if(m.find()){
         System.out.println(n-m.start()-1);
	}

       

    }
}